package com.yado.doubian.ui.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import android.text.method.TextKeyListener.clear

/**
 * a simple adapter for recyclerview, include item click, refresh
 */
open abstract class BaseBindingAdapter<T>(private val layoutId: Int, private val BRId: Int) :
    RecyclerView.Adapter<BaseBindingAdapter.TheViewHolder>() {

    private val mList: MutableList<T> by lazy { mutableListOf<T>() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheViewHolder {
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), layoutId, parent, false)
        val viewHolder = TheViewHolder(binding.root)
        viewHolder.binding = binding
        return viewHolder
    }

    override fun onBindViewHolder(holder: TheViewHolder, position: Int) {
        holder.binding.setVariable(BRId, mList[position])
        holder.binding.executePendingBindings()
        //
        mList[position]?.let {
            holder.itemView.setOnClickListener { itemClick(position, mList[position]) }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }


    //fun
    fun refresh(list: List<T>?) {
        list?.let {
            mList.clear()
            this.mList.addAll(list)
            notifyDataSetChanged()
        }
    }

    abstract fun itemClick(position: Int, t: T)



    //view holder
    class TheViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal lateinit var binding: ViewDataBinding
    }
}