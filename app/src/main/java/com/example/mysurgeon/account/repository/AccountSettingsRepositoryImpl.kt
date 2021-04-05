package com.example.mysurgeon.account.repository

import com.example.mysurgeon.core.PreferenceHelper
import javax.inject.Inject

class AccountSettingsRepositoryImpl @Inject constructor(): AccountSettingsRepository {
    @Inject
    lateinit var preferenceHelper: PreferenceHelper
    override val provideEmail: String
        get() = ""
    override val provideName: String
        get() = ""
}