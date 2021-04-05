package com.example.mysurgeon.splash.di

import com.example.mysurgeon.core.di.CoreComponent
import com.example.mysurgeon.splash.SplashViewModel
import dagger.Component
import dagger.Module

@SplashScope
@Component(modules = [SplashModule::class], dependencies = [CoreComponent::class])
interface SplashComponent {
    fun inject(viewModel: SplashViewModel)
}