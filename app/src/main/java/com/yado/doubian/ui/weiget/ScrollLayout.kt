package com.yado.doubian.ui.weiget

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import java.util.jar.Attributes

class ScrollLayout(ctx: Context, attributeset: AttributeSet?, defStyleAttr: Int) :
    LinearLayout(ctx, attributeset, defStyleAttr){
    constructor(ctx: Context) : this(ctx, null, 0)
    constructor(ctx: Context, attributeset: AttributeSet) : this(ctx, attributeset, 0)
}