package com.korniykom.spendless

import android.app.Application
import com.korniykom.spendless.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SpendLessApp: Application() {
    override fun onCreate() {
        super.onCreate()
         startKoin{
             androidContext(this@SpendLessApp)

             modules(appModule)
         }
    }
}