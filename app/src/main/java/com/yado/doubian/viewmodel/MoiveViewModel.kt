package com.yado.doubian.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.yado.doubian.AbsentLiveData
import com.yado.doubian.Resource
import com.yado.doubian.model.db.Repo
import com.yado.doubian.model.repostory.MovieRepository

class MoiveViewModel : ViewModel(){
    private lateinit var repository: MovieRepository
    private var loadMore = false
    var loading = MediatorLiveData<Boolean>()

    var result: LiveData<Resource<Repo>> = Transformations.switchMap(loading){ load ->
        if (load){
            repository.load()
        }else{
            AbsentLiveData.create()
        }
    }

    init {
        repository = MovieRepository()
    }
}