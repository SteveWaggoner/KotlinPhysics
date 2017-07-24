


class Entity constructor(x: Int, y: Int, var vx: Double = 0.0, var vy: Double = 0.0) {
    var x: Double = 0.toDouble()
        private set
    var y: Double = 0.toDouble()
        private set
    val radius: Double
    private val accelerations = ArrayList<Acceleration>()

    init {
        this.x = x.toDouble()
        this.y = y.toDouble()
        this.radius = 15.0
    }

    fun velVector(): Vector2D {
        return Vector2D(this.vx, this.vy)
    }

    fun applyDrag(drag: Double) {
        this.vx = drag * this.vx
        this.vy = drag * this.vy
    }

    fun sumAccel(): Acceleration {
        var xAccel = 0.0
        var yAccel = 0.0
        for (i in this.accelerations.indices) {
            xAccel += this.accelerations[i].ax
            yAccel += this.accelerations[i].ay
        }
        this.accelerations.clear()
        return Acceleration(xAccel, yAccel)
    }

    fun addAccel(a: Acceleration) {
        this.accelerations.add(a)
    }

    fun updateVelocity(vx: Double, vy: Double) {
        this.vx = vx
        this.vy = vy
    }

    fun updatePos(newX: Double, newY: Double) {
        this.x = newX
        this.y = newY
    }

    fun dimX(): Int {
        return (this.radius * 2).toInt()
    }

    fun dimY(): Int {
        return (this.radius * 2).toInt()
    }

    val center: Point2D
        get() = Point2D(this.x + this.dimX() / 2, this.y + this.dimY() / 2)

}