package com.yado.doubian.ui.adapter

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("visibleGone")
    fun showHide(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("imgUrl")
    fun showHide(view: ImageView, url: String) {
        Glide.with(view.context)
            .load(url)
//            .placeholder(holderDrawable)
//            .error(errorDrawable)
            .into(view)
    }
}