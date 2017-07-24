import swaggoner.kotlin.js.pixi.PIXI
import swaggoner.kotlin.js.pixi.renderers.Renderer
import swaggoner.kotlin.js.pixi.renderers.RendererOptions
import org.w3c.dom.HTMLCanvasElement


class PixiDisplay(val moveEngine:MoveEngine, val canvas :HTMLCanvasElement) : Runnable {

    var renderer : Renderer? = null;

    override fun setup() {
        val options = RendererOptions()
        options.view = canvas
        renderer = PIXI.autoDetectRenderer(640, 480, options)
    }

    override fun tick() {
        renderSpawns()
    }



    fun makeGrid(): PIXI.Graphics {
        val graphics = PIXI.Graphics()

        //grid
        for (y in 0..80) {
            var darkness = 0.2
            if (y % 10 == 0) darkness = 0.3
            if (y % 100 == 0) darkness = 0.4
            graphics.lineStyle(1, 0x33FF00, darkness).moveTo(0, 10 * y).lineTo(1600, 10 * y)
        }

        for (x in 0..160) {
            var darkness = 0.2
            if (x % 10 == 0) darkness = 0.3
            if (x % 100 == 0) darkness = 0.4
            graphics.lineStyle(1, 0x33FF00, darkness).moveTo(10 * x, 0).lineTo(10 * x, 800)
        }

        return graphics
    }


    fun makeDot(x:Double,y:Double,radius:Double, color:Int=0xFFFF0B) : PIXI.Graphics {
        val graphics = PIXI.Graphics()
        graphics.lineStyle(0).beginFill(color, 0.8).drawCircle(x, y, radius)
        return graphics
    }


    fun renderSpawns(): Unit  {

        val graphics = PIXI.Graphics()
        graphics.beginFill(0x0, 1.0).drawRect(0, 0, 1600, 800).endFill()

        graphics.addChild(makeGrid())

        for ( p in moveEngine.entities) {
            graphics.addChild(makeDot(p.x + p.radius,p.y - p.radius, p.radius, 0x00FF00))
        }

        if ( renderer != null ) {
            renderer?.render(graphics)
        } else {
            println("run setup?")
        }
    }

}


