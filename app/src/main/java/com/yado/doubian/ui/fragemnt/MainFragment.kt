package com.yado.doubian.ui.fragemnt

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.yado.doubian.R
import com.yado.doubian.autoCleared
import com.yado.doubian.databinding.FragmentMainBinding
import com.yado.doubian.ui.adapter.RepoAdapter
import com.yado.doubian.viewmodel.MoiveViewModel
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    private var inited = false
    private var binding by autoCleared<FragmentMainBinding>()
    private var adapter by autoCleared<RepoAdapter>()
    private val moiveViewModel = MoiveViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.fragment_main, container, false)
        if (!inited){
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
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
        adapter = RepoAdapter(){ pos, repo ->
            Log.e("tag", "pos = $pos")
        }
        recyclerView.adapter = adapter
    }

    private fun loadingData(){
        binding.loading = true
        moiveViewModel.loading.value = binding.loading
        moiveViewModel.result.observe(viewLifecycleOwner, Observer {it ->
            adapter.refresh(it.data)
        })
    }
}
