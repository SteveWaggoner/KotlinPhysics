import kotlin.js.Math

class BallAdder(val moveEngine:MoveEngine) : Runnable {

    override fun tick() {
            moveEngine.addBall(1, 1, Math.random() * 1000.0,
                    Math.random() * 1000.0);
    }

}