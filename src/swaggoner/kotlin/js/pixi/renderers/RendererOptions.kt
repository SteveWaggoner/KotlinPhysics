package swaggoner.kotlin.js.pixi.renderers

import org.w3c.dom.HTMLCanvasElement

@JsName("Object")
external open public class RendererOptions {
    /**
     * the canvas to use as a view, optional
     */
    var view: HTMLCanvasElement = definedExternally

    /**
     * If the render view is transparent, default false
     */
    var transparent: Boolean = definedExternally

    /**
     * sets antialias (only applicable in chrome at the moment)
     */
    var antialias: Boolean = definedExternally

    /**
     * enables drawing buffer preservation, enable this if you need to call toDataUrl on the webgl context
     */
    var preserveDrawingBuffer: Boolean = definedExternally

    /**
     * the resolution of the renderer retina would be 2
     */
    var resolution: Int = definedExternally

    /**
     * This sets if the Renderer will clear the context texture or not before the new render pass. If true:
     * If the Stage is NOT transparent, Pixi will clear to alpha (0, 0, 0, 0).
     * If the Stage is transparent, Pixi will clear to the target Stage's background color.
     * Disable this by setting this to false. For example: if your game has a canvas filling background image, you often don't need this set.
     */
    var clearBeforeRender: Boolean = definedExternally
}