package com.example.mcshippers.Profile.data

import com.cdt.sr.base.entities.APIResponse
import com.example.mcshippers.Profile.model.Profile

interface ProfleRepository {
    suspend fun insertProfiles(profiles: Profile)
    suspend fun getAllProfilesFromLocal():Profile
    suspend fun getAllProfilesFromRemote():Profile
}