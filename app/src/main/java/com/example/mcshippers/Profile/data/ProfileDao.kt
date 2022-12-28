package com.example.mcshippers.Profile.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mcshippers.Profile.model.Profile

@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Profile)

    @Query("select * from profile_list ")
    suspend fun getAllProflies(): Profile
}