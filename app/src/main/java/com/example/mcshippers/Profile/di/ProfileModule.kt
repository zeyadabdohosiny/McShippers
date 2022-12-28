package com.example.mcshippers.Profile.di

import com.example.mcshippers.Profile.data.*
import com.example.mcshippers.Profile.presentation.profileLists.viewModel.ProfileListViewModelImpl
import com.example.mcshippers.base.data.local.room.data.RoomDataBase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

var profileModule = module {
    single { get<RoomDataBase>().itemDao() }
    factory { get<Retrofit>().create(ApiService::class.java) }
    factory<LocalDataSource> { LocalDataSourceImpl(get()) }
    factory<RemoteDataSource> { RemoteDataSourceImpl(get()) }
    factory<ProfleRepository> { ProfleRepositoryImpl(get(), get(), get()) }
    viewModel { ProfileListViewModelImpl(get()) }
}