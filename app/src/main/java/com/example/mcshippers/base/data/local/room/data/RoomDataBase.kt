package com.example.mcshippers.base.data.local.room.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mcshippers.Profile.data.ProfileDao
import com.example.mcshippers.Profile.model.Converters
import com.example.mcshippers.Profile.model.Profile

@Database(
    entities = [Profile::class],
    version = 2
)
@TypeConverters(Converters::class)
abstract class RoomDataBase : RoomDatabase() {
    abstract fun itemDao(): ProfileDao
}