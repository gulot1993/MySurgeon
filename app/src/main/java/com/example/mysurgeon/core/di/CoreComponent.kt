package com.example.mysurgeon.core.di

import com.example.mysurgeon.core.PreferenceHelper
import dagger.Component
import javax.inject.Singleton

@Component(modules = [CoreModule::class])
@Singleton
interface CoreComponent {
    fun preferenceHelper(): PreferenceHelper
}