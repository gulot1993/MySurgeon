package com.example.mysurgeon.auth.repository

import com.example.mysurgeon.model.Login
import com.example.mysurgeon.model.LoginRequest
import retrofit2.http.Query

interface AuthRepository {
    suspend fun login(request: LoginRequest): Login
    suspend fun register(
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
    )

    suspend fun getStates(): List<String>
}