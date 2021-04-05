package com.example.mysurgeon.account.di

import com.example.mysurgeon.account.AccountSettingsViewModel
import com.example.mysurgeon.core.di.CoreComponent
import dagger.Component

@AccountSettingsScope
@Component(modules = [AccountSettingsModule::class], dependencies = [CoreComponent::class])
interface AccountSettingsComponent {
    fun inject(viewModel: AccountSettingsViewModel)
}