package com.poomgames.catfore.presentation

import android.app.Application
import com.onesignal.OneSignal
import com.poomgames.catfore.load.LoadCup
import com.poomgames.catfore.presentation.di.components.AppComponent
import com.poomgames.catfore.presentation.di.components.DaggerAppComponent

lateinit var LoadCup: LoadCup

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this)
        OneSignal.setAppId("dc6f72f7-884c-4dfe-9464-09a318d494a1")
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        LoadCup = LoadCup()
        appComponent = DaggerAppComponent.factory().create(this)

    }
}