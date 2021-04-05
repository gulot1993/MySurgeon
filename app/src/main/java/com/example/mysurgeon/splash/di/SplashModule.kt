package com.example.mysurgeon.splash.di

import com.example.mysurgeon.splash.repository.SplashRepository
import com.example.mysurgeon.splash.repository.SplashRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class SplashModule {
    @Provides
    fun provideSplashRepository(splashRepositoryImpl: SplashRepositoryImpl): SplashRepository
    = splashRepositoryImpl
}