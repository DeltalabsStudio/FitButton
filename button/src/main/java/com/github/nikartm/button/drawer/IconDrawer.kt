package com.github.nikartm.button.drawer

import android.text.TextUtils
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import com.github.nikartm.button.FitButton
import com.github.nikartm.button.model.FButton

/**
 * @author Ivan V on 27.03.2019.
 * @version 1.0
 */
internal class IconDrawer(val view: FitButton, val button: FButton)
    : Drawer<FitButton, FButton>(view, button) {

    private lateinit var iv: ImageView

    override fun draw() {
        initIcon()
        view.addView(iv)
    }

    override fun isReady(): Boolean {
        return button.icon != null && button.iconVisibility != View.GONE
    }

    // Prepare icon to the drawing
    private fun initIcon() : ImageView {
        iv = ImageView(view.context)
        iv.setImageDrawable(button.icon)
        iv.setColorFilter(button.iconColor)
        iv.visibility = button.iconVisibility
        val iconParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT, getWeight())
        iconParams.width = button.iconWidth.toInt()
        iconParams.height = button.iconHeight.toInt()
        iconParams.marginStart = button.iconMarginStart.toInt()
        iconParams.topMargin = button.iconMarginTop.toInt()
        iconParams.marginEnd = button.iconMarginEnd.toInt()
        iconParams.bottomMargin = button.iconMarginBottom.toInt()
        iconParams.gravity = button.gravity
        iv.layoutParams = iconParams
        return iv
    }

    // Get layout weight dependent on the layout orientation and a text state
    private fun getWeight() : Float {
        return when(view.orientation) {
            LinearLayout.VERTICAL -> {
                if (TextUtils.isEmpty(button.text)) 0f else 1f
            }
            else -> 0f
        }
    }

}
