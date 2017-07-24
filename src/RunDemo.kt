import org.w3c.dom.HTMLCanvasElement

@JsName("runDemo")
fun runDemo(canvas:HTMLCanvasElement) {

    val moveEngine = MoveEngine()

    moveEngine.addBall(50,50, 1.0, 0.0)
    moveEngine.addBall(10,20, 0.0, 100.0)
    moveEngine.addBall(40,30, 1.0, 1.0)

    val animationRunner = Runner( PixiDisplay(moveEngine, canvas), 30)
    animationRunner.start()

    val moveEngineRunner = Runner( moveEngine, 100)
    moveEngineRunner.start()

    val makeBallRunner = Runner( BallAdder(moveEngine), 1)
    makeBallRunner.start()
}


