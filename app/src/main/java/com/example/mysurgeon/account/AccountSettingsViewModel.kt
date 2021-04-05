package com.example.mysurgeon.account

import com.example.mysurgeon.account.di.AccountSettingsModule
import com.example.mysurgeon.account.di.DaggerAccountSettingsComponent
import com.example.mysurgeon.core.BaseViewModel
import com.example.mysurgeon.core.di.CoreComponent

class AccountSettingsViewModel(private val coreComponent: CoreComponent): BaseViewModel() {
    init {
        initComponentInjection()
    }
    override fun onDestroy() {

    }

    override fun initComponentInjection() {
        DaggerAccountSettingsComponent.builder()
            .coreComponent(coreComponent)
            .accountSettingsModule(AccountSettingsModule())
            .build()
            .apply {
                inject(this@AccountSettingsViewModel)
            }
    }
}