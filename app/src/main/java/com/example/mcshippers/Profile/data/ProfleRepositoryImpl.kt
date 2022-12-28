package com.example.mcshippers.Profile.data

import com.cdt.sr.base.entities.APIResponse
import com.example.mcshippers.Profile.model.Profile
import com.example.mcshippers.base.dispatchersThreads.DispatchersProvider
import kotlinx.coroutines.async

import kotlinx.coroutines.withContext

class ProfleRepositoryImpl(
    val localDataSource: LocalDataSource,
    val remoteDataSource: RemoteDataSource,
    val dispatcher: DispatchersProvider
) :
    ProfleRepository {
    override suspend fun insertProfiles(profiles: Profile) {
      return  withContext(dispatcher.ioThread()) {
            localDataSource.insertProfiles(profiles)
        }
    }

    override suspend fun getAllProfilesFromLocal(): Profile {
        return withContext(dispatcher.ioThread()) {
            localDataSource.getAllProfiles()
        }
    }

    override suspend fun getAllProfilesFromRemote(): Profile{
        return withContext(dispatcher.ioThread()) {
            remoteDataSource.getAllProfiles()
        }

    }
}