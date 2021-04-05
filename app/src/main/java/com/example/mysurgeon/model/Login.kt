package com.example.mysurgeon.model

import kotlinx.android.parcel.Parcelize

@Parcelize
data class Login(val userID: String,
                 val accessToken: String,
                 val paymentOption: String,
                 val expiryLastShown: String): Model()