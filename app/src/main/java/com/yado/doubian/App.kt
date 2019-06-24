package com.yado.doubian

import android.app.Application

class App : Application(){
    companion object{
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    private fun getApp(): App = instance
}