import kotlin.js.Math

class MoveEngine : Runnable {

    val GRAVITY = 1500.0
    val DRAG = 0.95
    val BOUNCE = 1.0

    val MAX_SPAWN = 50


    var curTime : Double = 0.0;
    var lastTime : Double = 0.0;
    var timePassed : Double = 0.0;
    var timeFraction : Double = 0.0;
    val constForces = ArrayList<Acceleration>()

    val entities = ArrayList<Entity>();


    override fun setup() {

        curTime = currentTimeMillis()
        initializeConstForces()
    }

    override fun tick() {
            updateTime();
            applyConstForces();
            sumForces();
            moveEntities();
    }


    fun initializeConstForces()
    {
        constForces.add(Acceleration(0.0, GRAVITY));
    }

    fun updateTime()
    {
        lastTime = curTime;
        curTime = currentTimeMillis();
        timePassed = (curTime - lastTime);
        timeFraction = (timePassed / 1000.0);
    }

    fun applyConstForces()
    {
        var xAccel = 0.0
        var yAccel = 0.0

        // Find the total acceleration of all const forces.
        for (force in constForces) {
                xAccel += force.ax;
                yAccel += force.ay;
        }

        // Apply the sum acceleration to each entity.
        for (spawn in entities) {
            spawn.addAccel(Acceleration(xAccel, yAccel))
        }
    }

    fun sumForces()
    {
        for (spawn in entities) {
            // Get the sum of all accelerations acting on object.
            val theAccel = spawn.sumAccel();
            // Apply the resulting change in velocity.
            val vx = spawn.vx + (theAccel.ax * timeFraction);
            val vy = spawn.vy + (theAccel.ay * timeFraction);
            spawn.updateVelocity(vx, vy);
            // Apply drag coefficient
            spawn.applyDrag(1.0 - (timeFraction * DRAG));
        }
    }


    fun moveEntities() {
        for (spawn in entities) {

            // Get the initial x and y coords.
            val oldX = spawn.x;
            val oldY = spawn.y
            // Calculate the new x and y coords.
            val newX = oldX + (spawn.vx * timeFraction);
            val newY = oldY + (spawn.vy * timeFraction);
            spawn.updatePos(newX, newY);
            checkWallCollisions(spawn);
        }
        checkCollisions();
    }


    fun checkCollisions()
    {
        for (spawn in entities) {
            val sCenter = spawn.center
            for (tspawn in entities) {
                val tCenter = tspawn.center
                val distBetween = sCenter.distance(tCenter);
                val bigR = if (spawn.radius > tspawn.radius) spawn.radius else tspawn.radius
                if (distBetween < (bigR * 2)) collide(spawn, tspawn, distBetween);
            }
        }
    }

    fun collide(s: Entity, t: Entity, distBetween:Double)
    {
        // Get the relative x and y dist between them.
        val relX = s.x - t.x
        val relY = s.y - t.y;
        // Take the arctan to find the collision angle.
        val collisionAngle = Math.atan2(relY, relX);
        // if (collisionAngle < 0) collisionAngle += 2 * Math.PI;
        // Rotate the coordinate systems for each object's velocity to align
        // with the collision angle. We do this by supplying the collision angle
        // to the vector's rotateCoordinates method.
        val sVel = s.velVector()
        val tVel = t.velVector()
        sVel.rotateCoordinates(collisionAngle);
        tVel.rotateCoordinates(collisionAngle);
        // In the collision coordinate system, the contact normals lie on the
        // x-axis. Only the velocity values along this axis are affected. We can
        // now apply a simple 1D momentum equation where the new x-velocity of
        // the first object equals a negative times the x-velocity of the
        // second.
        val swap = sVel.x
        sVel.x = tVel.x;
        tVel.x = swap;
        // Now we need to get the vectors back into normal coordinate space.
        sVel.restoreCoordinates();
        tVel.restoreCoordinates();
        // Give each object its new velocity.
        s.updateVelocity(sVel.x * BOUNCE, sVel.y * BOUNCE);
        t.updateVelocity(tVel.x * BOUNCE, tVel.y * BOUNCE);
        // Back them up in the opposite angle so they are not overlapping.
        val minDist = s.radius + t.radius
        val overlap = minDist - distBetween;
        val toMove = overlap / 2;
        var newX = s.x + (toMove * Math.cos(collisionAngle));
        var newY = s.y + (toMove * Math.sin(collisionAngle));
        s.updatePos(newX, newY);
        newX = t.x - (toMove * Math.cos(collisionAngle));
        newY = t.y - (toMove * Math.sin(collisionAngle));
        t.updatePos(newX, newY);
    }

    fun checkWallCollisions(s: Entity)
    {
        val maxY = 480.0
        val maxX = 610.0
        if (s.y > maxY) {
            s.updatePos(s.x, maxY);
            s.updateVelocity(s.vx, (s.vy * -BOUNCE));
        }
        if (s.x > maxX) {
            s.updatePos(maxX, s.y);
            s.updateVelocity((s.vx * -BOUNCE), s.vy);
        }
        if (s.x < 1) {
            s.updatePos(1.0, s.y);
            s.updateVelocity((s.vx * -BOUNCE), s.vy);
        }
    }


    fun addBall(x:Int, y:Int, vx:Double, vy:Double):Int
    {
        if (entities.size >= MAX_SPAWN) return 1;
        entities.add(Entity(x, y, vx, vy));
        return 0;
    }

    fun currentTimeMillis() : Double {
        return kotlin.js.Date().getTime()
    }

}
