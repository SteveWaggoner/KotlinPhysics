import kotlin.browser.window

class Runner(val runnable : Runnable, val framesPerSecond:Int) {
    private var intervalLoopId: Int? = null

    fun runTick() {
        runnable.tick()
    }

    fun start() {

        runnable.setup()

        intervalLoopId = window.setInterval({
            this.runTick()
        }, 1000 / framesPerSecond)
    }

    fun stop() {
        if (intervalLoopId != null)
            window.clearInterval(intervalLoopId!!)
        intervalLoopId = null
    }
}