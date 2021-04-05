package com.example.mysurgeon.auth.di

import com.example.mysurgeon.auth.repository.AuthRepository
import com.example.mysurgeon.auth.repository.AuthRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class AuthModule {
    @Provides
    fun provideLoginRepository(loginRepositoryImpl: AuthRepositoryImpl): AuthRepository = loginRepositoryImpl
}