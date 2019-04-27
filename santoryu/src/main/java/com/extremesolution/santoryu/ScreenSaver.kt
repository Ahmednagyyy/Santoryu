package com.extremesolution.santoryu

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.view.animation.Animation
import android.view.animation.AnimationUtils.loadAnimation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import com.extremesolution.screensaver.R
import java.util.*

/**
 * Created by Ahmed Nagi on 27/04/2019.
 * Version 1.0.0
 */
class ScreenSaver(context: Context, attrs: AttributeSet) : ImageView(context, attrs) {

    /**
     * @IMPORTANT
     * If you are gonna use the multiple screen saver with a custom duration
     *
     * Please set Animation duration with the same duration for better performance
     */

    /**
     * Default duration ( in seconds ) value for animation accruing
     */
    var duration: Long = 16000


    /**
     * [setSingleImage] A single screen saver image setter
     * (Version 1 -> drawables )
     * (Version 2 -> bitmap )
     **/


    /**
     * (Version 1 -> drawables )
     **/
    fun setSingleImage(image: Int) {
        val drawable = resources.getDrawable(image)
        val bitmap = (drawable as BitmapDrawable).bitmap
        setImageBitmap(bitmap)
    }

    /**
     * (Version 2 -> bitmap )
     **/
    fun setSingleImage(bitmap: Bitmap) {
        setImageBitmap(bitmap)
    }



    /**
     * [setMultiDrawables] A multiple screen saver image setter
     **/

    /**
     * With default duration value
     **/
    fun setMultiDrawables(imagesList: ArrayList<Int>) {
        val animation = AnimationDrawable()
        for (i in 0 until imagesList.size) {
            animation.addFrame(resources.getDrawable(imagesList[i]), (duration).toInt())
            animation.setEnterFadeDuration(3000)
            animation.setExitFadeDuration(2000)
            animation.isOneShot = false
            background = animation
            scaleType = ScaleType.CENTER

        }
        animation.start()

    }

    /**
     * With given duration value
     **/
    fun setMultiDrawables(listOfImages: ArrayList<Int>, seconds: Int) {
        val animation = AnimationDrawable()
        for (i in 0 until listOfImages.size) {
            animation.addFrame(resources.getDrawable(listOfImages[i]), seconds * 1000)
            animation.setEnterFadeDuration(seconds*187)
            animation.setExitFadeDuration(seconds*125)
            animation.isOneShot = false
            background = animation
            scaleType = ScaleType.CENTER

        }
        animation.start()

    }

    /**
     * [setMultiBitmap] A multiple screen saver image setter
     **/

    /**
     * With default duration value
     **/
    fun setMultiBitmap(listOfImages: ArrayList<Bitmap>) {
        val animation = AnimationDrawable()
        for (i in 0 until listOfImages.size) {
            val drawableImage = BitmapDrawable(resources, listOfImages[i])
            animation.addFrame(drawableImage, (duration).toInt())
            animation.setEnterFadeDuration(3000)
            animation.setExitFadeDuration(2000)
            animation.isOneShot = false
            background = animation
            scaleType = ScaleType.CENTER

        }
        animation.start()

    }

    /**
     *  With given duration value
     **/
    fun setMultiBitmap(listOfImages: ArrayList<Bitmap>, seconds: Int) {
        val animation = AnimationDrawable()
        for (i in 0 until listOfImages.size) {
            val drawableImage = BitmapDrawable(resources, listOfImages[i])
            animation.addFrame(drawableImage, seconds * 1000)
            animation.setEnterFadeDuration(seconds*187)
            animation.setExitFadeDuration(seconds*125)
            animation.isOneShot = false
            background = animation
            scaleType = ScaleType.CENTER


        }
        animation.start()

    }


    /**
     * [startScreenSaver] screen saver animation setup
     */


    /**
     * Default animation repeat value
     */
    fun startScreenSaver() {
        val zoomAnimation: Animation = loadAnimation(context, R.anim.screen_saver)
        startAnimation(zoomAnimation)
    }

    /**
     * With given animation xml resource
     */
    fun startScreenSaver(animation: Int) {
        startAnimation(loadAnimation(context, animation))
    }

    /**
     * Developer must set the values if he don't want to use resource file
     *
     * @param seconds Duration of the animation
     *
     * @param fromX Horizontal scaling factor to apply at the start of the animation
     *
     * @param toX Horizontal scaling factor to apply at the end of the animation
     *
     * @param fromY Vertical scaling factor to apply at the start of the animation
     *
     * @param toY Vertical scaling factor to apply at the end of the animation
     *
     * @param pivotX The X coordinate of the point about which the object is being scaled,
     * specified as an absolute number where 0 is the left edge.
     * (This point remains fixed while the object changes size.)
     *
     * @param pivotY The Y coordinate of the point about which the object is being scaled,
     *  specified as an absolute number where 0 is the top edge.
     *  (This point remains fixed while the object changes size.)
     *
     * @param repeat How many time animation should repeat
     *
     * @param reversed Boolean of animation type is reversed or restarted every time
     *
     */
    fun startScreenSaver(
        seconds: Long, fromX: Float, fromY: Float,
        toX: Float, toY: Float, pivotX: Float, pivotY: Float,
        repeat: Int, reversed: Boolean
    ): ScaleAnimation {


        animation = ScaleAnimation(
            fromX, toX, fromY, toY,
            Animation.RELATIVE_TO_SELF, pivotX,
            Animation.RELATIVE_TO_SELF, pivotY
        )

        animation.repeatCount = repeat

        duration = seconds * 1000
        animation.duration = seconds * 1000

        if (reversed) {
            animation.repeatMode = ScaleAnimation.REVERSE
        } else {
            animation.repeatMode = ScaleAnimation.RESTART

        }

        return animation as ScaleAnimation
    }


    /**
     * Has the same parameters of the above method
     *
     * if repeat didn't pass as a parameter animation will repeat forever
     *
     */
    fun startScreenSaver(
        seconds: Long, fromX: Float, fromY: Float,
        toX: Float, toY: Float, pivotX: Float, pivotY: Float,
        reversed: Boolean
    ): ScaleAnimation {


        animation = ScaleAnimation(
            fromX, toX, fromY, toY,
            Animation.RELATIVE_TO_SELF, pivotX,
            Animation.RELATIVE_TO_SELF, pivotY
        )

        duration = seconds * 1000
        animation.duration = seconds * 1000
        animation.repeatCount = ScaleAnimation.INFINITE


        if (reversed) {
            animation.repeatMode = ScaleAnimation.REVERSE
        } else {
            animation.repeatMode = ScaleAnimation.RESTART

        }

        return animation as ScaleAnimation
    }

    /**
     * Has the same parameters of the above methods
     *
     * With default Duration value
     * and
     * if repeat didn't pass as a parameter animation will repeat forever
     *
     */
    fun startScreenSaver(
        fromX: Float, fromY: Float,
        toX: Float, toY: Float, pivotX: Float, pivotY: Float,
        reversed: Boolean
    ): ScaleAnimation {


        animation = ScaleAnimation(
            fromX, toX, fromY, toY,
            Animation.RELATIVE_TO_SELF, pivotX,
            Animation.RELATIVE_TO_SELF, pivotY
        )

        animation.duration = duration
        animation.repeatCount = ScaleAnimation.INFINITE

        if (reversed) {
            animation.repeatMode = ScaleAnimation.REVERSE
        } else {
            animation.repeatMode = ScaleAnimation.RESTART

        }

        return animation as ScaleAnimation
    }


    /**
     * Has the same parameters of the above methods
     *
     * With default Duration value
     * and
     * @param repeat
     *
     */
    fun startScreenSaver(
        fromX: Float, fromY: Float,
        toX: Float, toY: Float, pivotX: Float, pivotY: Float,
        repeat: Int, reversed: Boolean
    ): ScaleAnimation {


        animation = ScaleAnimation(
            fromX, toX, fromY, toY,
            Animation.RELATIVE_TO_SELF, pivotX,
            Animation.RELATIVE_TO_SELF, pivotY
        )

        animation.repeatCount = repeat

        animation.duration = duration

        if (reversed) {
            animation.repeatMode = ScaleAnimation.REVERSE
        } else {
            animation.repeatMode = ScaleAnimation.RESTART

        }

        return animation as ScaleAnimation
    }


}




