package com.yado.doubian.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "news")
@TypeConverters(ZhihuNews.StoriesBeanConverters::class/*, ZhihuNews.TopStoriesBeanConverters::class*/)
data class ZhihuNews(
    @PrimaryKey
    val id: Int,
    var date: String?,
    var stories: List<StoriesBean>?/*,
    var top_stories: List<TopStoriesBean>?*/) {

    data class StoriesBean(
        var ga_prefix: String?,
        var id: Int = 0,
        var title: String?,
        var type: Int = 0,
        var isMultipic: Boolean,
        var images: List<String>?)

//    data class TopStoriesBean(
//        var ga_prefix: String?,
//        var id: Int = 0,
//        var image: String?,
//        var title: String?,
//        var type: Int = 0)


    //Converters
    class StoriesBeanConverters{
        @TypeConverter
        fun stringToObject(value: String): List<StoriesBean> {
            val listType = object : TypeToken<List<StoriesBean>>() {
            }.type
            return Gson().fromJson(value, listType)
        }

        @TypeConverter
        fun objectToString(list: List<StoriesBean>): String {
            val gson = Gson()
            return gson.toJson(list)
        }
    }

    //Converters
//    class TopStoriesBeanConverters{
//        @TypeConverter
//        fun stringToObject(value: String): List<TopStoriesBean> {
//            val listType = object : TypeToken<List<TopStoriesBean>>() {
//            }.type
//            return Gson().fromJson(value, listType)
//        }
//
//        @TypeConverter
//        fun objectToString(list: List<TopStoriesBean>): String {
//            val gson = Gson()
//            return gson.toJson(list)
//        }
//    }
}