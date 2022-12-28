package com.example.mcshippers.base.koin

import android.app.Application
import com.example.mcshippers.Profile.di.profileModule
import com.example.mcshippers.base.dispatchersThreads.dispathersModule
import com.example.mcshippers.base.data.local.room.di.roomMoudle
import com.example.mcshippers.base.data.remote.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinDi : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KoinDi)
            modules(
                listOf(
                    roomMoudle,
                    dispathersModule,
                    retrofitModule,
                    profileModule
                )
            )
        }
    }
}