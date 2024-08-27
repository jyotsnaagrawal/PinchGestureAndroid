package com.jyotsna.pinchgesture2app

import android.content.Context
import android.graphics.Matrix
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import androidx.appcompat.widget.AppCompatImageView
import kotlin.math.max
import kotlin.math.min

class ZoomableImageView(context: Context, attrs: AttributeSet) : AppCompatImageView(context, attrs) {

    private val matrix = Matrix() // Initialize a Matrix object for handling image transformations
    private var scale = 1f // Initial scale factor set to 1 (no scaling)
    private var scaleDetector: ScaleGestureDetector // Declare a ScaleGestureDetector for detecting pinch-to-zoom gestures

    // Initialization block where scaleDetector is created and the image matrix is set
    init {
        scaleDetector = ScaleGestureDetector(context, ScaleListener()) // Initialize the ScaleGestureDetector with a ScaleListener
        imageMatrix = matrix // Set the imageMatrix to the custom matrix for transformations

        scaleType = ScaleType.MATRIX // Set the scale type to MATRIX to allow custom matrix transformations
    }

    // Override the onTouchEvent method to handle touch events
    override fun onTouchEvent(event: MotionEvent): Boolean {
        scaleDetector.onTouchEvent(event) // Pass the touch event to the ScaleGestureDetector for handling scale gestures
        return true
    }

    // Define an inner class to handle scale gestures
    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            // Update the scale factor based on the gesture's scale factor
            scale *= detector.scaleFactor
            // Restrict the scale factor to a minimum of 0.1 and a maximum of 5.0
            scale = max(0.1f, min(scale, 5.0f))
            // Apply the new scale factor to the matrix
            matrix.setScale(scale, scale)
            // Set the imageMatrix to apply the scaling transformation
            imageMatrix = matrix
            return true
        }
    }
}
