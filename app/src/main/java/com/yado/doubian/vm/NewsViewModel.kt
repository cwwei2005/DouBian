package com.yado.doubian.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.yado.doubian.AbsentLiveData
import com.yado.doubian.Resource
import com.yado.doubian.model.db.ZhihuNews
import com.yado.doubian.model.repostory.NewsRepository

class NewsViewModel : ViewModel(){
    private var repository: NewsRepository = NewsRepository()
    var loading = MediatorLiveData<Boolean>()
    var result: LiveData<Resource<ZhihuNews>> = Transformations.switchMap(loading){ loading ->
        if (loading){
            repository.load()
        }else{
            AbsentLiveData.create()
        }
    }
}