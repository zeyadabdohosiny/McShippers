package com.example.mcshippers.Profile.data

import com.cdt.sr.base.entities.APIResponse
import com.example.mcshippers.Profile.model.Profile

class RemoteDataSourceImpl(var api: ApiService) : RemoteDataSource {
    override suspend fun getAllProfiles()=api.getAllProfiles()
}