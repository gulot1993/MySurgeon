package com.example.mysurgeon.model

import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginDTO(
                    val result: String,
                    val error: String,
                    val userID: String,
                    val accessToken: String,
                    val paymentOption: String,
                    val expiryLastShown: String): Model()