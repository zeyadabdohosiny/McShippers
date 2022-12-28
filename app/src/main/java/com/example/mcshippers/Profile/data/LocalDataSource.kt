package com.example.mcshippers.Profile.data

import com.example.mcshippers.Profile.model.Profile

interface LocalDataSource {
    suspend fun insertProfiles(profiles: Profile)
    suspend fun getAllProfiles():Profile
}