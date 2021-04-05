package com.example.mysurgeon.splash.repository

import com.example.mysurgeon.core.PreferenceHelper
import com.example.mysurgeon.core.network.NetworkModule
import com.example.mysurgeon.core.service.API
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class SplashRepositoryImpl @Inject constructor(): SplashRepository {

    @Inject
    lateinit var preferenceHelper: PreferenceHelper

    private val api: API
        get() = NetworkModule.getInstance().provideApi()

    override fun isLoggedIn(): Boolean {
        return preferenceHelper.isLoggedIn
    }

}