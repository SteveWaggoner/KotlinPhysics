import kotlin.js.Math

class Point2D(var x: Double, var y: Double)  {

    fun distance(p2:Point2D) : Double {
        val dx = (x-p2.x)
        val dy = (y-p2.y)
        return Math.sqrt((dx*dx)+(dy*dy))

    }
}
