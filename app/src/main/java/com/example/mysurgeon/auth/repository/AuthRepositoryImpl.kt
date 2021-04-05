package com.example.mysurgeon.auth.repository

import com.example.mysurgeon.core.PreferenceHelper
import com.example.mysurgeon.core.data.toLogin
import com.example.mysurgeon.core.network.NetworkModule
import com.example.mysurgeon.core.service.API
import com.example.mysurgeon.model.Login
import com.example.mysurgeon.model.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(): AuthRepository {
    private val api: API
        get() = NetworkModule.getInstance().provideApi()

    @Inject
    lateinit var preferenceHelper: PreferenceHelper

    override suspend fun login(request: LoginRequest): Login = withContext(Dispatchers.IO){
       return@withContext try {
           val response = api.login(request.mode, request.username, request.password)
           if (response.result == "OKAY") {
               preferenceHelper.isLoggedIn = true
               preferenceHelper.loginInfo = response.toLogin()
               response.toLogin()
           } else {
               throw (Throwable("Email or Password is incorrect"))
           }
       } catch (e: Throwable) {
           throw (e)
       }
    }

    fun isLoggedIn(): Boolean = preferenceHelper.isLoggedIn

    override suspend fun register(mode: String,
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
                                  mobileNo:
                                  String,
                                  landlineNo: String,
                                  email_update: String,
                                  iphone_update: String) = withContext(Dispatchers.IO) {
                                      try {
                                          val response = api.register(
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
                                          Timber.d("responseeeee $response")
                                      } catch (e: Throwable) {
                                          throw (e)
                                      }
    }

    override suspend fun getStates(): List<String> {
        return api.getStates("COUNTRY")
    }
}