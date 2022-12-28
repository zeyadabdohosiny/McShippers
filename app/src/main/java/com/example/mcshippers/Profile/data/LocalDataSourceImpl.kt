package com.example.mcshippers.Profile.data

import com.example.mcshippers.Profile.model.Profile

class LocalDataSourceImpl(var dao:ProfileDao) :LocalDataSource {
    override suspend fun insertProfiles(profiles: Profile) {
        dao.insert(profiles)
    }
    override suspend fun getAllProfiles()=dao.getAllProflies()
}