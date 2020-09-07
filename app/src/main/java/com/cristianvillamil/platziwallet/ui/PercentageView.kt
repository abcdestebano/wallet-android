package com.cristianvillamil.platziwallet.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.FrameLayout
import com.cristianvillamil.platziwallet.R
import kotlinx.android.synthetic.main.percertange_view.view.*

class PercentageView : FrameLayout {

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) :
            super(context, attrs, defStyle) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView()
    }

    constructor(context: Context) : super(context) {
        initView()
    }

    private fun initView() {
        val view = View.inflate(context, R.layout.percertange_view, null)
        addView(view)
        progressCircularBar.setProgressWithAnimation(
            70f,
            1000,
            AccelerateDecelerateInterpolator(),
            300
        )
    }
}