package swaggoner.kotlin.js.pixi.geom

/**
 * the Rectangle object is an area defined by its position, as indicated by its top-left corner Point (x, y) and
 * by its width and its height.
 */
@JsModule("PIXI")
@JsName("Rectangle")
external public class Rectangle(
        /** The X coord of the upper-left corner of the rectangle */
        x: Double,

        /** The Y coord of the upper-left corner of the rectangle */
        y: Double,

        /** The overall width of this rectangle */
        width: Double,

        /** The overall height of this rectangle */
        height: Double
): Shape {
    /**
     * Creates a clone of this Rectangle
     * @return a copy of the rectangle
     */
    public fun clone(): Rectangle = definedExternally

    /**
     * Checks whether the x and y coordinates passed to this function are contained within this Rectangle
     * @param x The X coordinate of the Point to test
     * @param y The y coordinate of the Point to test
     * @return Whether the x/y coords are within this Rectangle
     */
    public fun contains(x: Double, y: Double): Boolean = definedExternally
}
