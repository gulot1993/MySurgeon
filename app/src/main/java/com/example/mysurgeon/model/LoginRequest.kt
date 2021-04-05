package com.example.mysurgeon.model

import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginRequest(val mode: String,
                        val username: String,
                        val password: String): Model()