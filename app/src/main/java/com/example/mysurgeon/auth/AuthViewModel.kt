package com.example.mysurgeon.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mysurgeon.R
import com.example.mysurgeon.auth.di.AuthModule
import com.example.mysurgeon.auth.di.DaggerAuthComponent
import com.example.mysurgeon.auth.repository.AuthRepository
import com.example.mysurgeon.core.BaseViewModel
import com.example.mysurgeon.core.di.CoreComponent
import com.example.mysurgeon.core.status.PageMovements
import com.example.mysurgeon.core.status.Status
import com.example.mysurgeon.model.LoginRequest
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthViewModel(val coreComponent: CoreComponent): BaseViewModel() {

    @Inject
    lateinit var repository: AuthRepository

    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status>
        get() = _status

    private val _states = MutableLiveData<List<String>>()
    val states: LiveData<List<String>>
        get() = _states

    init {
        initComponentInjection()
    }

    fun nextPage(offset: Int) {
        _status.value = PageMovements.NextPage(offset = offset)
    }

    fun previousPage(offset: Int) {
        _status.value = PageMovements.PreviousPage(offset = offset)
    }

    override fun onDestroy() {

    }

    fun login(loginRequest: LoginRequest) {
       viewModelScope.launch {
           try {
                _status.value = Status.Loading(show = true)
                val login = repository.login(loginRequest)
               _status.value = Status.Loading(show = false)
               _status.value = Status.Success()
           } catch (e: Throwable) {
                _status.value = Status.Loading(show = false)
                _status.value = Status.Error(message = e.message)
           }
       }
    }

    fun register(
            mode: String,
            promoCode: String,
            firstName: String,
            lastName: String,
            email: String,
            username: String,
            password: String,
            retypedPassword: String,
            street: String,
            state: String,
            city: String,
            zip: String,
            mobileNo: String,
            landlineNo: String,
            email_update: String,
            iphone_update: String
    ) {
        viewModelScope.launch {
            try {
                if (password != retypedPassword) {
                    _status.value = Status.Error(resId = R.string.tv_password_not_match)
                    return@launch
                } else if (password.length < 6) {
                    _status.value = Status.Error(resId = R.string.tv_short_password)
                    return@launch
                }
                _status.value = Status.Loading(show = true)
                repository.register(
                        mode,
                        promoCode,
                        firstName,
                        lastName,
                        email,
                        username,
                        password,
                        retypedPassword,
                        street,
                        state,
                        city,
                        zip,
                        mobileNo,
                        landlineNo,
                        email_update,
                        iphone_update
                )
                _status.value = Status.Loading(show = false)
            } catch (e: Throwable) {
                _status.value = Status.Loading(show = false)
                _status.value = Status.Error(message = e.message)
            }
        }
    }

    override fun initComponentInjection() {
        DaggerAuthComponent.builder()
            .coreComponent(coreComponent)
            .authModule(AuthModule())
            .build()
            .apply {
                inject(this@AuthViewModel)
            }
    }

    fun getStates() {
        viewModelScope.launch {
            _states.value = repository.getStates()
        }
    }
}