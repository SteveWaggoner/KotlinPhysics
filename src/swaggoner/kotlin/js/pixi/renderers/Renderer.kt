package swaggoner.kotlin.js.pixi.renderers

import org.w3c.dom.HTMLCanvasElement
import swaggoner.kotlin.js.pixi.PIXI

/**
 * The common interface of CanvasRenderer and WebGLRenderer
 */
external abstract class Renderer(
        /**
         * the width of the canvas view
         */
        width: Int = definedExternally,

        /**
         * the height of the canvas view
         */
        height: Int = definedExternally,

        /**
         * The optional renderer parameters
         */
        options: RendererOptions = definedExternally
) {
    public val type: Int = definedExternally

    /**
     * The resolution of the renderer
     */
    public var resolution: Int = definedExternally

    /**
     * Whether the render view is transparent
     */
    public var transparent: Boolean = definedExternally

    /**
     * The value of the preserveDrawingBuffer flag affects whether or not the contents of the stencil buffer is retained after rendering.
     */
    public var preserveDrawingBuffer: Boolean = definedExternally

    /**
     * This sets if the Renderer will clear the context texture or not before the new render pass. If true:
     * If the Stage is NOT transparent, Pixi will clear to alpha (0, 0, 0, 0).
     * If the Stage is transparent, Pixi will clear to the target Stage's background color.
     * Disable this by setting this to false. For example: if your game has a canvas filling background image, you often don't need this set.
     */
    public var clearBeforeRender: Boolean = definedExternally

    /**
     * The canvas element that everything is drawn to
     */
    public val view: HTMLCanvasElement = definedExternally

    /**
     * Renders the stage to its webGL view
     * @param stage the Stage element to be rendered
     */
    public fun render(stage: PIXI.Graphics): Unit = definedExternally

    /**
     * Resizes the view to the specified width and height.
     *
     * @param width the new width of the webGL view
     * @param height the new height of the webGL view
     */
    public fun resize(width: Number, height: Number): Unit = definedExternally
}
