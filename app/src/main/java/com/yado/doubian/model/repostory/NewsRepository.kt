package com.yado.doubian.model.repostory

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.yado.doubian.Resource
import com.yado.doubian.model.NetworkBoundResource
import com.yado.doubian.model.db.Repo
import com.yado.doubian.model.db.MyDatabase
import com.yado.doubian.model.db.ZhihuNews
import com.yado.doubian.model.net.MyRetrofit

/**
 * 不同的数据类型应该使用不同的repository类
 */
class NewsRepository {

    fun load(): LiveData<Resource<ZhihuNews>>{
        return object: NetworkBoundResource<ZhihuNews, ZhihuNews>(){
            override fun saveCallResult(item: ZhihuNews) {
                MyDatabase.getInstance().newsDao().insert(item)
            }
            override fun shouldFetch(data: ZhihuNews?) = data == null
            override fun loadFromDb() = MyDatabase.getInstance().newsDao().query()
            override fun createCall() = MyRetrofit.getInstance().api.getLastNews()
        }.asLiveData()
    }
}