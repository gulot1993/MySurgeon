package com.example.mysurgeon.model

import androidx.annotation.IntDef

class SettingsType {
    companion object {
        @Retention(AnnotationRetention.SOURCE)
        @IntDef(TYPE_HEADER, TYPE_ITEM)
        annotation class TYPE

        const val TYPE_HEADER = 0
        const val TYPE_ITEM = 1
    }
}