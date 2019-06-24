package com.yado.doubian.model.repostory

import android.app.Application
import androidx.lifecycle.LiveData
import com.yado.doubian.Resource
import com.yado.doubian.model.NetworkBoundResource
import com.yado.doubian.model.RepoSearchResponse
import com.yado.doubian.model.db.Repo
import com.yado.doubian.model.db.MyDatabase

class MovieRepository {

    fun load(): LiveData<Resource<Repo>>{
        return object : NetworkBoundResource<Repo, RepoSearchResponse>(){
            override fun saveCallResult(item: RepoSearchResponse) {
                MyDatabase.getInstance(Application()).repoDao().insert(item.items)
            }

            override fun shouldFetch(data: Repo?): Boolean {
                return data == null
            }

            override fun loadFromDb(): LiveData<Repo> {
                return MyDatabase.getInstance(Application()).repoDao().loadFromDb()
            }

        }.asLiveData()
    }
}