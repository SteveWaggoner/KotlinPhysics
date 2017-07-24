package swaggoner.kotlin.js.pixi

import swaggoner.kotlin.js.pixi.display.DisplayObjectContainer
import swaggoner.kotlin.js.pixi.geom.Point
import swaggoner.kotlin.js.pixi.geom.Rectangle
import swaggoner.kotlin.js.pixi.renderers.Renderer
import swaggoner.kotlin.js.pixi.renderers.RendererOptions

external object PIXI {
    public val WEBGL_RENDERER: Int = definedExternally
    public val CANVAS_RENDERER: Int = definedExternally

    /**
     * the scale modes
     */
    public object scaleModes {
        public val DEFAULT: Int = definedExternally
        public val LINEAR: Int = definedExternally
        public val NEAREST: Int = definedExternally
    }

    /**
     * Various blend modes supported by pixi. IMPORTANT - The WebGL renderer only supports the NORMAL, ADD, MULTIPLY and SCREEN blend modes.
     */
    public object blendModes {
        public val NORMAL: Int = definedExternally
        public val ADD: Int = definedExternally
        public val MULTIPLY: Int = definedExternally
        public val SCREEN: Int = definedExternally
        public val OVERLAY: Int = definedExternally
        public val DARKEN: Int = definedExternally
        public val LIGHTEN: Int = definedExternally
        public val COLOR_DODGE: Int = definedExternally
        public val COLOR_BURN: Int = definedExternally
        public val HARD_LIGHT: Int = definedExternally
        public val SOFT_LIGHT: Int = definedExternally
        public val DIFFERENCE: Int = definedExternally
        public val EXCLUSION: Int = definedExternally
        public val HUE: Int = definedExternally
        public val SATURATION: Int = definedExternally
        public val COLOR: Int = definedExternally
        public val LUMINOSITY: Int = definedExternally
    }


    @JsModule("PIXI")
    @JsName("autoDetectRenderer")
    fun autoDetectRenderer(width: Number, height: Number, options: RendererOptions): Renderer = definedExternally

    @JsModule("PIXI")
    @JsName("Stage")
    class Stage(
            /**
             * the background color of the stage, you have to pass this in is in hex format
             * like: 0xFFFFFF for white
             */
            backgroundColor: Int,

            /** Whether or not the stage is interactive */
            interactive: Boolean = definedExternally)
        : DisplayObjectContainer {

    }

    @JsModule("PIXI")
    @JsName("Graphics")
    class Graphics: DisplayObjectContainer {
        /** The alpha value used when filling the Graphics object. */
        var fillAlpha: Number

        /** The width (thickness) of any lines drawn. */
        var lineWidth: Number

        /** The color of any lines drawn. */
        var lineColor: String

        /** The tint applied to the graphic shape. This is a hex value. Apply a value of 0xFFFFFF to reset the tint. */
        var tint: Number

        /** The blend mode to be applied to the graphic shape. Apply a value of PIXI.blendModes.NORMAL to reset the blend mode. */
        var blendMode: Number

        /** Whether this shape is being used as a mask. */
        var isMask: Boolean

        /** The bounds' padding used for bounds calculation. */
        var boundsPadding: Number

        /**
         * Specifies the line style used for subsequent calls to Graphics methods such as the lineTo() method or the drawCircle() method.
         *
         * @param lineWidth width of the line to draw, will update the objects stored style
         * @param color color of the line to draw, will update the objects stored style
         * @param alpha alpha of the line to draw, will update the objects stored style
         */
        public fun lineStyle(lineWidth: Number, color: Number=definedExternally, alpha: Double=definedExternally): swaggoner.kotlin.js.pixi.primitives.Graphics = definedExternally

        /**
         * Moves the current drawing position to x, y.
         *
         * @param x the X coordinate to move to
         * @param y the Y coordinate to move to
         */
        public fun moveTo(x: Number, y: Number): swaggoner.kotlin.js.pixi.primitives.Graphics = definedExternally

        /**
         * Draws a line using the current line style from the current drawing position to (x, y);
         * The current drawing position is then set to (x, y).
         *
         * @param x the X coordinate to draw to
         * @param y the Y coordinate to draw to
         */
        public fun lineTo(x: Number, y: Number): swaggoner.kotlin.js.pixi.primitives.Graphics = definedExternally

        /**
         * Calculate the points for a quadratic bezier curve and then draws it.
         * Based on: https://stackoverflow.com/questions/785097/how-do-i-implement-a-bezier-curve-in-c
         *
         * @param cpX Control point x
         * @param cpY Control point y
         * @param toX Destination point x
         * @param toY Destination point y
         */
        public fun quadraticCurveTo(cpX: Number, cpY: Number, toX: Number, toY: Number): swaggoner.kotlin.js.pixi.primitives.Graphics = definedExternally

        /**
         * Calculate the points for a bezier curve and then draws it.
         *
         * @param cpX Control point x
         * @param cpY Control point y
         * @param cpX2 Second Control point x
         * @param cpY2 Second Control point y
         * @param toX Destination point x
         * @param toY Destination point y
         */
        public fun bezierCurveTo(cpX: Number, cpY: Number, cpX2: Number, cpY2: Number, toX: Number, toY: Number): swaggoner.kotlin.js.pixi.primitives.Graphics = definedExternally

        /*
         * The arcTo() method creates an arc/curve between two tangents on the canvas.
         *
         * "borrowed" from https://code.google.com/p/fxcanvas/ - thanks google!
         *
         * @param x1 The x-coordinate of the beginning of the arc
         * @param y1 The y-coordinate of the beginning of the arc
         * @param x2 The x-coordinate of the end of the arc
         * @param y2 The y-coordinate of the end of the arc
         * @param radius The radius of the arc
         */
        public fun arcTo(x1: Number, y1: Number, x2: Number, y2: Number, radius: Number): swaggoner.kotlin.js.pixi.primitives.Graphics = definedExternally

        /**
         * The arc method creates an arc/curve (used to create circles, or parts of circles).
         *
         * @param cx The x-coordinate of the center of the circle
         * @param cy The y-coordinate of the center of the circle
         * @param radius The radius of the circle
         * @param startAngle The starting angle, in radians (0 is at the 3 o'clock position of the arc's circle)
         * @param endAngle The ending angle, in radians
         * @param anticlockwise Optional. Specifies whether the drawing should be counterclockwise or clockwise. False is default, and indicates clockwise, while true indicates counter-clockwise.
         */
        public fun arc(cx: Number, cy: Number, radius: Number, startAngle: Number, endAngle: Number, anticlockwise: Boolean = definedExternally): swaggoner.kotlin.js.pixi.primitives.Graphics = definedExternally

        /**
         * Specifies a simple one-color fill that subsequent calls to other Graphics methods
         * (such as lineTo() or drawCircle()) use when drawing.
         *
         * @param color the color of the fill
         * @param alpha the alpha of the fill
         */
        public fun beginFill(color: Number, alpha: Double = definedExternally): swaggoner.kotlin.js.pixi.primitives.Graphics = definedExternally

        /**
         * Applies a fill to the lines and shapes that were added since the last call to the beginFill() method.
         */
        public fun endFill(): swaggoner.kotlin.js.pixi.primitives.Graphics = definedExternally

        /**
         * @param x The X coord of the top-left of the rectangle
         * @param y The Y coord of the top-left of the rectangle
         * @param width The width of the rectangle
         * @param height The height of the rectangle
         */
        public fun drawRect(x: Number, y: Number, width: Number, height: Number): swaggoner.kotlin.js.pixi.primitives.Graphics = definedExternally

        /**
         * @param x The X coord of the top-left of the rectangle
         * @param y The Y coord of the top-left of the rectangle
         * @param width The width of the rectangle
         * @param height The height of the rectangle
         * @param radius Radius of the rectangle corners
         */
        public fun drawRoundedRect(x: Number, y: Number, width: Number, height: Number, radius: Number): swaggoner.kotlin.js.pixi.primitives.Graphics = definedExternally

        /**
         * Draws a circle.
         *
         * @param x The X coordinate of the center of the circle
         * @param y The Y coordinate of the center of the circle
         * @param radius The radius of the circle
         */
        public fun drawCircle(x: Number, y: Number, radius: Number): swaggoner.kotlin.js.pixi.primitives.Graphics = definedExternally

        /**
         * Draws an ellipse.
         *
         * @param x The X coordinate of the center of the ellipse
         * @param y The Y coordinate of the center of the ellipse
         * @param width The half width of the ellipse
         * @param height The half height of the ellipse
         */
        public fun drawEllipse(x: Number, y: Number, width: Number, height: Number): swaggoner.kotlin.js.pixi.primitives.Graphics = definedExternally

        /**
         * Draws a polygon using the given path.
         *
         * @param path The path data used to construct the polygon.
         */
        public fun drawPolygon(path: Array<Point>): swaggoner.kotlin.js.pixi.primitives.Graphics = definedExternally

        /**
         * Clears the graphics that were drawn to this Graphics object, and resets fill and line style settings.
         */
        public fun clear(): swaggoner.kotlin.js.pixi.primitives.Graphics = definedExternally


        /**
         * Retrieves the bounds of the graphic shape as a rectangle object
         *
         * @method getBounds
         * @return the rectangular bounding area
         */
        override public fun getBounds(): Rectangle = definedExternally

        /**
         * Update the bounds of the object
         */
        public fun updateLocalBounds(): Unit = definedExternally

        /**
         * Destroys a previous cached sprite.
         */
        public fun destroyCachedSprite(): Unit = definedExternally

        /**
         * Draws the given shape to this Graphics object. Can be any of Circle, Rectangle, Ellipse, Line or Polygon.
         *
         * @param shape The Shape object to draw.
         * @return The generated GraphicsData object.
         */
        //  public fun drawShape(shape: Shape): GraphicsData = definedExternally
    }


}

