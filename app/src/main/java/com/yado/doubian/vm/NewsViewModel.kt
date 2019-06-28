package com.yado.doubian.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.yado.doubian.AbsentLiveData
import com.yado.doubian.Resource
import com.yado.doubian.model.db.ZhihuNews
import com.yado.doubian.model.repostory.NewsRepository

/**
 * livedata的成员定义为val
 */
class NewsViewModel : ViewModel(){
    private val repository: NewsRepository = NewsRepository()  //repository实例
    val loading = MediatorLiveData<Boolean>()  //可观察的
    val result: LiveData<Resource<ZhihuNews>> = Transformations.switchMap(loading){ loading ->
        if (loading){
            repository.load()
        }else{
            AbsentLiveData.create()
        }
    }
}