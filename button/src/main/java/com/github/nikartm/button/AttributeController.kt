package com.github.nikartm.button

import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import com.github.nikartm.button.model.FButton
import com.github.nikartm.button.model.IconPosition
import com.github.nikartm.button.model.Shape
import com.github.nikartm.button.util.txtPxToSp

/**
 * @author Ivan V on 25.03.2019.
 * @version 1.0
 */
internal class AttributeController(private val view: View, private val attrs: AttributeSet?) {

    /**
     * @return initialized [FButton]
     */
    lateinit var button: FButton

    init {
        initAttr()
    }

    private fun initAttr() {
        val typedArray = view.context.obtainStyledAttributes(attrs, R.styleable.FitButton)
        // Init button image
        val icon = typedArray.getDrawable(R.styleable.FitButton_fb_icon)
        val iconColor = typedArray.getColor(R.styleable.FitButton_fb_iconColor, Color.TRANSPARENT)
        val iconWidth = typedArray.getDimension(
                R.styleable.FitButton_fb_iconWidth, icon?.intrinsicWidth?.toFloat() ?: 0f
        )
        val iconHeight = typedArray.getDimension(
                R.styleable.FitButton_fb_iconHeight, icon?.intrinsicHeight?.toFloat() ?: 0f
        )
        val iconMarginStart = typedArray.getDimension(R.styleable.FitButton_fb_iconMarginStart, 0f)
        val iconMarginTop = typedArray.getDimension(R.styleable.FitButton_fb_iconMarginTop, 0f)
        val iconMarginEnd = typedArray.getDimension(R.styleable.FitButton_fb_iconMarginEnd, 0f)
        val iconMarginBottom = typedArray.getDimension(R.styleable.FitButton_fb_iconMarginBottom, 0f)
        val iconPosition = typedArray.getInt(R.styleable.FitButton_fb_iconPosition, IconPosition.CENTER.position)
        val iconVisibility = typedArray.getInt(R.styleable.FitButton_fb_iconVisibility, View.VISIBLE)

        // Init divider
        val divColor = typedArray.getColor(R.styleable.FitButton_fb_divColor, Color.DKGRAY)
        val divWidth = typedArray.getDimension(R.styleable.FitButton_fb_divWidth, 0f)
        val divHeight = typedArray.getDimension(R.styleable.FitButton_fb_divHeight, 0f)
        val divMarginTop = typedArray.getDimension(R.styleable.FitButton_fb_divMarginTop, 0f)
        val divMarginBottom = typedArray.getDimension(R.styleable.FitButton_fb_divMarginBottom, 0f)
        val divMarginStart = typedArray.getDimension(R.styleable.FitButton_fb_divMarginStart, 0f)
        val divMarginEnd = typedArray.getDimension(R.styleable.FitButton_fb_divMarginEnd, 0f)
        val divVisibility = typedArray.getInt(R.styleable.FitButton_fb_divVisibility, View.VISIBLE)

        // Init button text
        val text = typedArray.getString(R.styleable.FitButton_fb_text)
        val textPaddingStart = typedArray.getDimension(R.styleable.FitButton_fb_textPaddingStart, 0f)
        val textPaddingTop = typedArray.getDimension(R.styleable.FitButton_fb_textPaddingTop, 0f)
        val textPaddingEnd = typedArray.getDimension(R.styleable.FitButton_fb_textPaddingEnd, 0f)
        val textPaddingBottom = typedArray.getDimension(R.styleable.FitButton_fb_textPaddingBottom, 0f)
        val fontPath = typedArray.getString(R.styleable.FitButton_fb_fontFamily)
        val textFont = if (fontPath != null) Typeface.createFromFile(fontPath) else Typeface.DEFAULT
        val textStyle = typedArray.getInt(R.styleable.FitButton_fb_textStyle, Typeface.NORMAL)
        val textSize = typedArray.getDimension(R.styleable.FitButton_fb_textSize, txtPxToSp(16f))
        val textColor = typedArray.getColor(R.styleable.FitButton_fb_textColor, Color.DKGRAY)
        val textAllCaps = typedArray.getBoolean(R.styleable.FitButton_fb_textAllCaps, false)
        val textVisibility = typedArray.getInt(R.styleable.FitButton_fb_textVisibility, View.VISIBLE)
        val textGravity = typedArray.getInt(R.styleable.FitButton_fb_textGravity, Gravity.CENTER)

        // Init button
        val btnColor = typedArray.getColor(R.styleable.FitButton_fb_backgroundColor, 0)
        val cornerRadius = typedArray.getDimension(R.styleable.FitButton_fb_cornerRadius, 0f)
        val showRipple = typedArray.getBoolean(R.styleable.FitButton_fb_showRipple, true)
        val rippleColor = typedArray.getColor(R.styleable.FitButton_fb_rippleColor, Color.parseColor("#42FFFFFF"))
        val shape = typedArray.getInt(R.styleable.FitButton_fb_shape, Shape.RECTANGLE.shape)
        val gravity = typedArray.getInt(R.styleable.FitButton_fb_gravity, Gravity.CENTER)
        val borderColor = typedArray.getColor(R.styleable.FitButton_fb_borderColor, Color.TRANSPARENT)
        val borderWidth = typedArray.getDimension(R.styleable.FitButton_fb_borderWidth, 0f)

        button = FButton(icon,
                iconColor,
                iconWidth,
                iconHeight,
                iconMarginStart,
                iconMarginTop,
                iconMarginEnd,
                iconMarginBottom,
                IconPosition.values().first { ic -> ic.position == iconPosition },
                iconVisibility,
                divColor,
                divWidth,
                divHeight,
                divMarginTop,
                divMarginBottom,
                divMarginStart,
                divMarginEnd,
                divVisibility,
                text,
                textPaddingStart,
                textPaddingTop,
                textPaddingEnd,
                textPaddingBottom,
                textFont,
                textStyle,
                textSize,
                textColor,
                textAllCaps,
                textVisibility,
                textGravity,
                btnColor,
                cornerRadius,
                showRipple,
                rippleColor,
                Shape.values().first { s -> s.shape == shape },
                gravity,
                borderColor,
                borderWidth)

        typedArray.recycle()
    }

}
