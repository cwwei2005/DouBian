package com.yado.doubian.ui.weiget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import java.util.jar.Attributes

class RecyclerViewX(ctx: Context, attributeset: AttributeSet?, defStyleAttr: Int) :
    RecyclerView(ctx, attributeset, defStyleAttr) {
    constructor(ctx: Context) : this(ctx, null, 0)
    constructor(ctx: Context, attributeset: AttributeSet) : this(ctx, attributeset, 0)

    var isTop = false
    var isBottom = false



    override fun onInterceptTouchEvent(e: MotionEvent?): Boolean {
        if (isBottom) return true
        return super.onInterceptTouchEvent(e)
    }

    var lastY = 0f
    override fun onTouchEvent(e: MotionEvent?): Boolean {
        val y = e!!.y
        when(e.action){
            MotionEvent.ACTION_DOWN ->{

            }
            MotionEvent.ACTION_MOVE ->{
                if (isBottom){
                     val dy = y - lastY
                    Log.e("tag", "dy = $dy")
//                    scrollBy(10, dy.toInt())
                }
            }
            MotionEvent.ACTION_UP ->{

            }
        }
        lastY = y
        return super.onTouchEvent(e)
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        isTop = !canScrollVertically(-1)  //-1代表顶部,返回true表示没到顶,还可以滑
        isBottom = !canScrollVertically(1)//1代表底部,返回true表示没到底部,还可以滑
    }
}