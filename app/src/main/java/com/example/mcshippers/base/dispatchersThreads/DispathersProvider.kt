package com.example.mcshippers.base.dispatchersThreads

import kotlinx.coroutines.CoroutineDispatcher

interface DispatchersProvider {
    fun ioThread(): CoroutineDispatcher
    fun mainThread(): CoroutineDispatcher
    fun defultThread(): CoroutineDispatcher
    fun unConfiedThread(): CoroutineDispatcher
}