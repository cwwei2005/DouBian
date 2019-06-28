package com.yado.doubian.ui.fragemnt

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.yado.doubian.R
import com.yado.doubian.autoCleared
import com.yado.doubian.databinding.FragmentNewsBinding
import com.yado.doubian.ui.adapter.NewsAdapter
import com.yado.doubian.vm.NewsViewModel
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment() {
    private var inited = false
    private var binding by autoCleared<FragmentNewsBinding>()
    private var adapter by autoCleared<NewsAdapter>()
    private val vm = NewsViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.fragment_news, container, false)
        if (!inited){
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!inited){
            inited = true
            binding.lifecycleOwner = viewLifecycleOwner
            initRecyclerView()
            loadingData()
        }
    }

    private fun initRecyclerView() {
        adapter = NewsAdapter(){ pos, bean ->
//            Log.e("tag", "pos = $pos, ${bean.title}")
            val bundle = bundleOf("title" to bean.title)
            Navigation.findNavController(binding.root).navigate(R.id.action_mainFragment_to_detailFragment, bundle)
        }
        recyclerView.adapter = adapter
        binding.result = vm.result  //为了使用result的loading状态
    }

    private fun loadingData(){
        vm.loading.value = true  //触发vm.result进行一次赋值
        vm.result.observe(viewLifecycleOwner, Observer {
            adapter.refresh(it.data?.stories)
        })
    }
}
