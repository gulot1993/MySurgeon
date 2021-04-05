package com.example.mysurgeon.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mysurgeon.auth.AuthStatus
import com.example.mysurgeon.core.BaseViewModel
import com.example.mysurgeon.core.di.CoreComponent
import com.example.mysurgeon.core.status.Status
import com.example.mysurgeon.splash.di.DaggerSplashComponent
import com.example.mysurgeon.splash.di.SplashModule
import com.example.mysurgeon.splash.repository.SplashRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class SplashViewModel(private var coreComponent: CoreComponent): BaseViewModel() {

    @Inject
    lateinit var repository: SplashRepository

    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status>
        get() = _status

    init {
        initComponentInjection()
    }

    override fun onDestroy() {

    }

    fun start() {
        viewModelScope.launch {
            delay(3000)
            Timber.d("isssssssss ${repository.isLoggedIn()}")
            if (repository.isLoggedIn()) {
                _status.value = AuthStatus.NavigateToMain
            } else {
                _status.value = AuthStatus.NavigateToAuth
            }
        }
    }

    override fun initComponentInjection() {
        DaggerSplashComponent.builder()
            .coreComponent(coreComponent)
            .splashModule(SplashModule())
            .build()
            .apply { inject(this@SplashViewModel) }
    }
}