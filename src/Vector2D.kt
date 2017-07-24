import kotlin.js.Math

class Vector2D(var x: Double, var y: Double) {
    var restoreAngle: Double = 0.toDouble()

    init {
        this.restoreAngle = 0.0
    }

    fun angle(): Double {
        return Math.atan2(y, x)
    }

    fun mag(): Double {
        return Math.sqrt(x * x + y * y)
    }

    fun rotateCoordinates(tiltAngle: Double) {
        this.restoreAngle += tiltAngle
        var angle = angle()
        val mag = mag()
        angle -= tiltAngle
        x = mag * Math.cos(angle)
        y = mag * Math.sin(angle)
    }

    fun restoreCoordinates() {
        var angle = angle()
        val mag = mag()
        angle += restoreAngle
        x = mag * Math.cos(angle)
        y = mag * Math.sin(angle)
        restoreAngle = 0.0
    }
}