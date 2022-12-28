package com.example.mcshippers.base.dispatchersThreads

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class StandardDispathers : DispatchersProvider {
    override fun ioThread(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    override fun mainThread(): CoroutineDispatcher {
        return Dispatchers.Main
    }

    override fun defultThread(): CoroutineDispatcher {
        return Dispatchers.Default

    }

    override fun unConfiedThread(): CoroutineDispatcher {
        return Dispatchers.Unconfined
    }
}