package com.example.mcshippers.base.dispatchersThreads

import org.koin.dsl.bind
import org.koin.dsl.module

var dispathersModule = module {
    factory { StandardDispathers() } bind DispatchersProvider::class
}