package com.yado.doubian.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.yado.doubian.BR
import com.yado.doubian.R
import com.yado.doubian.databinding.MovieItemBinding
import com.yado.doubian.model.db.Repo
import com.yado.doubian.model.db.ZhihuNews

class NewsAdapter(private val clickCallback: ((pos: Int, storiesBean: ZhihuNews.StoriesBean) -> Unit)? =
                      { _, _ -> }) :
    BaseBindingAdapter<ZhihuNews.StoriesBean>(R.layout.news_item, BR.story, clickCallback)
