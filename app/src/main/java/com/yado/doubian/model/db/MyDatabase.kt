package com.yado.doubian.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yado.doubian.App

@Database(entities = [Repo::class, ZhihuNews::class], version = 1)
abstract class MyDatabase : RoomDatabase(){
    companion object {
        @Volatile private var intence: MyDatabase? = null

        fun getInstance(): MyDatabase{
            if (intence == null){
                synchronized(MyDatabase::class.java){
                    if (intence == null){
                        intence = Room.databaseBuilder(App.instance, MyDatabase::class.java, "my.db").build()
                    }
                }
            }
            return intence!!
        }
    }

    abstract fun repoDao(): RepoDao
    abstract fun newsDao(): ZhihuNewsDao
}