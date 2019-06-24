package com.yado.doubian.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.lifecycle.LiveData
import androidx.room.Query


@Dao
interface RepoDao{
    @Insert
    abstract fun insert(repo: Repo)

    @Query("select * from repo")  //查询所有
    fun loadFromDb(): LiveData<Repo>
}