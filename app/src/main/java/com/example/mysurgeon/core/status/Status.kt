package com.example.mysurgeon.core.status

import androidx.annotation.StringRes

open class Status {
    data class Success(val message: String? = null): Status()
    data class Error(val message: String? = null, @StringRes val resId: Int? = null): Status()
    data class Loading(val show: Boolean, val message: String? = null, @StringRes val resId: Int? = null): Status()
}