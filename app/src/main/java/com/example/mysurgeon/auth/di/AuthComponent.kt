package com.example.mysurgeon.auth.di

import com.example.mysurgeon.auth.AuthViewModel
import com.example.mysurgeon.core.di.CoreComponent
import dagger.Component

@AuthScope
@Component(dependencies = [CoreComponent::class], modules = [AuthModule::class])
interface AuthComponent {
    fun inject(viewModel: AuthViewModel)
}