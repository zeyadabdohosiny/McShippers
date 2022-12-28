package com.example.mcshippers.Profile.data

import com.cdt.sr.base.entities.APIResponse
import com.example.mcshippers.Profile.model.Profile
import retrofit2.http.GET

interface ApiService {
    @GET("f227855df4d197d3737c304e9377c4d4/raw/ece2a30b16a77ee58091886bf6d3445946e10a23")
    suspend fun getAllProfiles():Profile
}