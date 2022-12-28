package com.example.mcshippers.Profile.data

import com.cdt.sr.base.entities.APIResponse
import com.example.mcshippers.Profile.model.Profile

interface RemoteDataSource {
    suspend fun getAllProfiles():Profile
}