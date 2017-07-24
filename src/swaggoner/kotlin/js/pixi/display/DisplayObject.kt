package swaggoner.kotlin.js.pixi.display

import swaggoner.kotlin.js.pixi.geom.Point
import swaggoner.kotlin.js.pixi.geom.Geometry
import swaggoner.kotlin.js.pixi.geom.Rectangle
import swaggoner.kotlin.js.pixi.primitives.Graphics

/**
 * The base class for all objects that are rendered on the screen.
 * This is an abstract class and should not be used on its own rather it should be extended.
 */
@JsModule("PIXI")
@JsNonModule
@JsName("DisplayObject")
external abstract public class DisplayObject {
    /**
     * The coordinate of the object relative to the local coordinates of the parent.
     */
    public var position: Point = definedExternally

    /**
     * The position of the displayObject on the x axis relative to the local coordinates of the parent.
     */
    public var x: Double = definedExternally

    /**
     * The position of the displayObject on the y axis relative to the local coordinates of the parent.
     */
    public var y: Double = definedExternally

    /**
     * The scale factor of the object.
     */
    public var scale: Point = definedExternally

    /**
     * The pivot Point of the displayObject that it rotates around
     */
    public var pivot: Point = definedExternally

    /**
     * The rotation of the object in radians.
     */
    public var rotation: Double = definedExternally

    /**
     * The opacity of the object.
     */
    public var alpha: Double = definedExternally

    /**
     * The visibility of the object.
     */
    public var visible: Boolean = definedExternally

    /**
     * Indicates if the sprite is globally visible.
     */
    public val worldVisible: Boolean = definedExternally

    /**
     * This is the defined area that will pick up mouse / touch events. It is null by default.
     * Setting it is a neat way of optimising the hitTest function that the InteractionManager will use (as it will not need to hit test all the children)
     */
    public var hitArea: Geometry? = definedExternally

    /**
     * This is used to indicate if the displayObject should display a mouse hand cursor on rollover
     */
    public var buttonMode: Boolean = definedExternally

    /**
     * Can this object be rendered
     */
    open public var renderable: Boolean = definedExternally

    /**
     * The display object container that contains this display object.
     */
    public val parent: DisplayObjectContainer? = definedExternally

    /**
     * The stage the display object is connected to, or undefined if it is not connected to the stage.
     */
    public val stage: Stage? = definedExternally

    /**
     * The multiplied alpha of the displayObject
     */
    public val worldAlpha: Double = definedExternally

    /**
     * This is the cursor that will be used when the mouse is over this object. To enable this the element must have interactive = true and buttonMode = true
     */
    public var defaultCursor: String = definedExternally

    /**
     * The area the filter is applied to like the hitArea this is used as more of an optimisation
     * rather than figuring out the dimensions of the displayObject each frame you can set this rectangle
     */
    public var filterArea: Rectangle? = definedExternally

    /**
     * Indicates if the sprite will have touch and mouse interactivity. It is false by default
     */
    open public var interactive: Boolean = definedExternally

    /**
     * Sets a mask for the displayObject. A mask is an object that limits the visibility of an object to the shape of the mask applied to it.
     * In PIXI a regular mask must be a PIXI.Graphics object. This allows for much faster masking in canvas as it utilises shape clipping.
     * To remove a mask, set this property to null.
     */
    public var mask: Graphics? = definedExternally


    /**
     * Set if this display object is cached as a bitmap.
     * This basically takes a snap shot of the display object as it is at that moment. It can provide a performance benefit for complex static displayObjects.
     * To remove simply set this property to false
     */
    public var cacheAsBitmap: Boolean = definedExternally



    /**
     * Retrieves the local bounds of the displayObject as a rectangle object
     */
    open public fun getLocalBounds(): Rectangle = definedExternally

    /**
     * Sets the object's stage reference, the stage this object is connected to
     *
     * @param stage The stage that the object will have as its current stage reference
     */
    open public fun setStageReference(stage: Stage): Unit = definedExternally


    /**
     * Generates and updates the cached sprite for this object
     */
    public fun updateCache(): Unit = definedExternally

    /**
     * Calculates the global position of the display object
     *
     * @param position The world origin to calculate from
     * @return A Point object representing the position of this object
     */
    public fun toGlobal(position: Point): Point = definedExternally

    /**
     * Calculates the local position of the display object relative to another Point
     *
     * @param position The world origin to calculate from
     * @param [from] The DisplayObject to calculate the global position from
     * @return A Point object representing the position of this object
     */
    public fun toLocal(position: Point, from: DisplayObject? = definedExternally): Point = definedExternally
}