package com.yado.doubian.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ZhihuNewsDao {
    @Insert
    fun insert(news: ZhihuNews)

    @Query("select * from news")  //查询所有
    fun query(): LiveData<ZhihuNews>
}