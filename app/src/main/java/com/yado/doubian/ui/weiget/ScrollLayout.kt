package com.yado.doubian.ui.weiget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.LinearLayout
import android.widget.Scroller
import java.util.jar.Attributes

class ScrollLayout(ctx: Context, attributeset: AttributeSet?, defStyleAttr: Int) :
    LinearLayout(ctx, attributeset, defStyleAttr){
    constructor(ctx: Context) : this(ctx, null, 0)
    constructor(ctx: Context, attributeset: AttributeSet) : this(ctx, attributeset, 0)
    private var scroller: Scroller

    companion object{
        var isBottom = false
    }

    init {
        isClickable = true
        scroller = Scroller(ctx)
    }


    override fun onInterceptTouchEvent(e: MotionEvent?): Boolean {
        if (isBottom) return true
        return super.onInterceptTouchEvent(e)
    }

    var lastY = 0f
    var totalY = 0f
    override fun onTouchEvent(e: MotionEvent?): Boolean {
        val y = e!!.y
        when(e.action){
            MotionEvent.ACTION_DOWN ->{
                if (!scroller.isFinished()) scroller.abortAnimation();
            }
            MotionEvent.ACTION_MOVE ->{
//                if (isBottom){
                    val dy = lastY - y
                        scrollBy(0, dy.toInt())
                        totalY += dy
                if (dy < 0) isBottom = false
//                Log.e("tag", "totalY = $totalY")
//                }
            }
            MotionEvent.ACTION_UP ->{
//                Log.e("tag", "dy")
                smoothScrollTo(0, 0)
                totalY = 0f
            }
        }
        lastY = y
        return super.onTouchEvent(e)
    }

    override fun computeScroll() {
        super.computeScroll()
        if (scroller.computeScrollOffset()){
            scrollTo(scroller.getCurrX(), scroller.getCurrY())
            invalidate()
        }
    }


    //设置开始开始滑动的位置getScrollX(), dstY和目标位置dstX，dstY， 2000是滑动的时间。
    fun smoothScrollTo(dstX: Int, dstY: Int) {
        scroller.startScroll(scrollX, scrollY, dstX - scrollX, dstY- scrollY, 1000)
        invalidate()  //调用一次computeScroll
    }

}