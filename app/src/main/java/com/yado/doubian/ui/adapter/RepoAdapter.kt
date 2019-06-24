package com.yado.doubian.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.yado.doubian.BR
import com.yado.doubian.R
import com.yado.doubian.databinding.MovieItemBinding
import com.yado.doubian.model.db.Repo

class RepoAdapter(private val clickCallback: ((repo: Repo, pos: Int) -> Unit)?) :
    BaseBindingAdapter<Repo>(R.layout.movie_item, BR.repo){

    override fun itemClick(position: Int, t: Repo) {
        clickCallback
    }

}
