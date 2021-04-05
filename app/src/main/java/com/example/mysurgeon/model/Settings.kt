package com.example.mysurgeon.model

import kotlinx.android.parcel.Parcelize

@Parcelize
data class Settings(@SettingsType.Companion.TYPE val type: Int, val name: String): Model() {
    companion object {
        const val ITEM_LOGOUT = 0
        const val ITEM_CHANGE_PASSWORD = 1
        const val ITEM_CHANGE_USERNAME = 2
    }
}