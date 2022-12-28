package com.example.mcshippers.base.data.local.room.di

import android.app.Application
import androidx.room.Room
import com.example.mcshippers.base.data.local.room.data.RoomDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val roomMoudle = module {
    fun getInstance(application: Application): RoomDataBase {
        return Room.databaseBuilder(application, RoomDataBase::class.java, "Zeyad_Room")
            .fallbackToDestructiveMigration()
            .build()
    }
    single { getInstance(androidApplication()) }
}