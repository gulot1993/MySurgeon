package com.example.mysurgeon.account.di

import com.example.mysurgeon.account.repository.AccountSettingsRepository
import com.example.mysurgeon.account.repository.AccountSettingsRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class AccountSettingsModule {
    @Provides
    @AccountSettingsScope
    internal fun provideAccountSettingsRepository(repository: AccountSettingsRepositoryImpl): AccountSettingsRepository = repository
}