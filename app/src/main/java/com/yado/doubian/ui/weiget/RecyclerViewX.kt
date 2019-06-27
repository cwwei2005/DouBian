package com.yado.doubian.ui.weiget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.LinearLayout
import android.widget.Scroller
import androidx.recyclerview.widget.RecyclerView
import java.util.jar.Attributes

class RecyclerViewX(ctx: Context, attributeset: AttributeSet?, defStyleAttr: Int) :
    RecyclerView(ctx, attributeset, defStyleAttr) {
    constructor(ctx: Context) : this(ctx, null, 0)
    constructor(ctx: Context, attributeset: AttributeSet) : this(ctx, attributeset, 0)

    var isTop = false
    var isBottom = false
//    private var scroller: Scroller

//    init {
//        isClickable = true
//        scroller = Scroller(ctx)
//    }

    override fun onInterceptTouchEvent(e: MotionEvent?): Boolean {
//        if (isBottom) return true
        return super.onInterceptTouchEvent(e)
    }

//    var lastY = 0f
//    var totalY = 0f
//    override fun onTouchEvent(e: MotionEvent?): Boolean {
//        val y = e!!.y
//        when(e.action){
//            MotionEvent.ACTION_DOWN ->{
////                Log.e("tag", "dy")
//            }
//            MotionEvent.ACTION_MOVE ->{
////                if (isBottom){
//                val dy = lastY - y
//                if (dy > 0){
//                    smoothScrollBy(0, -dy.toInt())
//                    totalY += dy
//                }
////                Log.e("tag", "totalY = $totalY")
////                }
//            }
//            MotionEvent.ACTION_UP ->{
////                Log.e("tag", "dy")
//                smoothScrollTo(0, 0)
//                totalY = 0f
//            }
//        }
//        lastY = y
//        return super.onTouchEvent(e)
//    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        isTop = !canScrollVertically(-1)  //-1代表顶部,返回true表示没到顶,还可以滑
        isBottom = !canScrollVertically(1)//1代表底部,返回true表示没到底部,还可以滑
        if (isBottom) isNestedScrollingEnabled = false
        ScrollLayout.isBottom = isBottom
    }


//    override fun computeScroll() {
//        super.computeScroll()
//        if (scroller.computeScrollOffset()) {
//            scrollTo(scroller.currX, scroller.currY)
//            invalidate()
//        }
//    }


    //设置开始开始滑动的位置getScrollX(), dstY和目标位置dstX，dstY， 2000是滑动的时间。
//    fun smoothScrollTo(dstX: Int, dstY: Int) {
//        scroller.startScroll(scrollX, dstY, dstX - scrollX, dstY, 3000)
//        invalidate()  //调用一次computeScroll
//    }
}