package com.yado.doubian.model.net


import androidx.lifecycle.LiveData
import com.yado.doubian.model.db.ZhihuNews
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface HttpApi {
    @GET("before/20190101")
    fun getLastNews(): LiveData<ApiResponse<ZhihuNews>>
}
