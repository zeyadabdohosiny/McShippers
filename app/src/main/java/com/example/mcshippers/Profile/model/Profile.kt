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