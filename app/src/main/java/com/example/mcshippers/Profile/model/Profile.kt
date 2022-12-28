package com.example.mcshippers.Profile.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "profile_list")
data class Profile(
    @PrimaryKey(autoGenerate = false    )
    val id: Int,
    val athletes: List<Athlete>?
)

