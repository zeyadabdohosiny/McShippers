package com.example.mcshippers.Profile.model

import androidx.room.ColumnInfo
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class Athlete(
    @ColumnInfo(name="brief")
    val brief: String,
    @ColumnInfo(name="iamge")
    val image: String,
    @ColumnInfo(name="name")
    val name: String
)

class Converters {
    @TypeConverter
    fun fromItemsToJson(list: List<Athlete>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromGsonToListOfItem(value: String?): List<Athlete> {
        val gson = Gson()
        var listType =object: TypeToken<List<Athlete>>() {}.getType()
        return gson.fromJson(value, listType)
    }

}
