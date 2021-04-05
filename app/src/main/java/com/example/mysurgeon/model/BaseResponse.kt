package com.example.mysurgeon.model

import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class BaseResponse<T>(
    val result: String,
    val error: String,
    val data: @RawValue T
):Model()