package com.example.remotecontroljoystick.views

import android.R
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.graphics.alpha
import kotlin.math.min


class Joystick @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var centerX = 50.toFloat()
    var centerY = 50.toFloat()
    var initialCenterX = 0F
    var initialCenterY = 0F
    var radius: Float = 0F
    var canvasWidth: Int = 0
    var canvasHeight: Int = 0
    lateinit var onChange: (Float, Float) -> Float

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 55.0f
        typeface = Typeface.create("", Typeface.BOLD)

    }

    fun normalizeAileron(x: Float): Float {
        return (2 * (x / canvasWidth) - 1)
    }

    fun normalizeElevator(x: Float): Float {
        return ((2 * (x / canvasHeight) - 1) * -1)
    }


    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        radius = 120F
        initialCenterX = (width / 2).toFloat()
        initialCenterY = (height / 2).toFloat()

        centerX = initialCenterX
        centerY = initialCenterY
        canvasWidth = width
        canvasHeight = height
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.rgb(103, 58, 183)
        canvas.drawCircle(initialCenterX, initialCenterY, radius * 2, paint)
        paint.color = Color.rgb(30, 4, 78)
        canvas.drawCircle(centerX, centerY, radius, paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        var action = event.action


        if (action != MotionEvent.ACTION_UP) {
            if (!(centerX + radius > canvasWidth || centerX - radius < 0 || centerY - radius < 0 || centerY + radius > canvasHeight)) {
                centerX = event.x
                centerY = event.y
            }
            if (centerX + radius > canvasWidth) {
                centerX = canvasWidth - radius
            }
            if (centerX - radius < 0) {
                centerX = radius
            }
            if (centerY - radius < 0) {
                centerY = radius
            }
            if (centerY + radius > canvasHeight) {
                centerY = canvasHeight - radius
            }

        } else {
            centerX = initialCenterX
            centerY = initialCenterY
        }

        onChange(normalizeAileron(centerX), normalizeElevator(centerY))
        invalidate()
        return true
    }


}