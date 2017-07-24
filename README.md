KotlinPhysics
=============
Demo of Kotlin JS with PixiJS display

![Alt text](/docs/screenshot.png?raw=true "Screenshot")

Description
-----------
This is a Kotlin port of [Mike Wilkerson's Java 2D Physics Engine](https://github.com/wilkystyle/java2dphysicsengine) but using [PixiJS](http://www.pixijs.com/) for the display. Github has a couple of [Kotlin-Pixi wrappers](https://github.com/abesto/pixi-kotlin) but these are out of date. So, the project includes my very primative Pixi wrapper that at least compiles and does basic graphics. Not really suitable for much else.

Couple of things about the code
-------------------------------
* Thread and Coroutines didn't seem to work in Kotlin JS. So, the `Runnable.kt` and `Runner.kt` will run code for the browser. These classes are like timer with a `tick()` event. For animation, these were easier to use than threads.
* The Kotlin-Pixi wrapper can easily be expanded by adding classes to the `PIXI.kt`. Just add them to the PIXI object and the namespace in both Kotlin and Javascript would be the same. For example, `PIXI.Graphics` is the class name in both Kotlin and Javascript languages.

Final Thoughts
--------------
* Kotlin is a nice language when used with Intellij IDEA. Also, more readable than some Scala code.
* Scala has more support. Loading a full PIXIJS fascade was a one liner. And Kotlin noone has even wrote one yet.
 
