package com.example.mysurgeon.core.di

import android.content.Context
import com.example.mysurgeon.core.PreferenceHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule(val context: Context) {
    @Provides
    @Singleton
    fun providePreferenceHelper(): PreferenceHelper = PreferenceHelper.getInstance(context = context)
}