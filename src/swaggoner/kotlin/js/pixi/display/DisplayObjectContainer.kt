package swaggoner.kotlin.js.pixi.display

import swaggoner.kotlin.js.pixi.geom.Rectangle

/**
 * A DisplayObjectContainer represents a collection of display objects.
 * It is the base class of all display objects that act as a container for other objects.
 */
@JsModule("PIXI")
@JsNonModule
@JsName("DisplayObjectContainer")
external open class DisplayObjectContainer : DisplayObject {
    /**
     *  The array of children of this container.
     */
    public val children: Array<DisplayObject> = definedExternally

    /**
     * Adds a child to the container.
     *
     * @param child The DisplayObject to add to the container
     * @return child that was added.
     */
    public fun addChild(child: DisplayObject): DisplayObject = definedExternally

    /**
     * Adds a child to the container at a specified index. If the index is out of bounds an error will be thrown
     *
     * @param child The child to add
     * @param index The index to place the child in
     * @return The child that was added.
     */
    public fun addChildAt(child: DisplayObject, index: Int): DisplayObject = definedExternally

    /**
     * Swaps the position of 2 PixiDisplay Objects within this container.
     */
    public fun swapChildren(child: DisplayObject, child2: DisplayObject): Unit = definedExternally

    /**
     * Returns the index position of a child DisplayObject instance
     *
     * @param child The DisplayObject instance to identify
     * @return The index position of the child display object to identify
     */
    public fun getChildIndex(child: DisplayObject): Int = definedExternally

    /**
     * Changes the position of an existing child in the display object container
     *
     * @param child The child DisplayObject instance for which you want to change the index number
     * @param index The resulting index number for the child display object
     */
    public fun setChildIndex(child: DisplayObject, index: Int): Unit = definedExternally

    /**
     * Returns the child at the specified index
     *
     * @param index The index to get the child from
     * @return The child at the given index, if any.
     */
    public fun getChildAt(index: Int): DisplayObject = definedExternally

    /**
     * Removes a child from the container.
     *
     * @param child The DisplayObject to remove
     * @return The child that was removed.
     */
    public fun removeChild(child: DisplayObject): Unit = definedExternally

    /**
     * Removes a child from the specified index position.
     *
     * @param index The index to get the child from
     * @return The child that was removed.
     */
    public fun removeChildAt(index: Int): DisplayObject = definedExternally

    /**
     * Removes all children from this container that are within the begin and end indexes.
     *
     * @param beginIndex The beginning position. Default value is 0.
     * @param endIndex The ending position. Default value is size of the container.
     */
    public fun removeChildren(beginIndex: Int = definedExternally, endIndex: Int = definedExternally): Array<DisplayObject> = definedExternally

    /**
     * Retrieves the bounds of the displayObjectContainer as a rectangle. The bounds calculation takes all visible children into consideration.
     *
     * @return The rectangular bounding area
     */
    open public fun getBounds(): Rectangle = definedExternally

    /**
     * Retrieves the non-global local bounds of the displayObjectContainer as a rectangle. The calculation takes all visible children into consideration.
     *
     * @return The rectangular bounding area
     */
    override public fun getLocalBounds(): Rectangle = definedExternally

    /**
     * Sets the containers Stage reference. This is the Stage that this object, and all of its children, is connected to.
     *
     * @param stage The stage that the container will have as its current stage reference
     */
    override public fun setStageReference(stage: Stage): Unit = definedExternally

    /**
     * Removes the current stage reference from the container and all of its children.
     */
    public fun removeStageReference(): Unit = definedExternally

    /**
     * The width of the displayObjectContainer, setting this will actually modify the scale to achieve the value set
     */
    public open var width: Double = definedExternally

    /**
     * The height of the displayObjectContainer, setting this will actually modify the scale to achieve the value set
     */
    public open var height: Double = definedExternally
}