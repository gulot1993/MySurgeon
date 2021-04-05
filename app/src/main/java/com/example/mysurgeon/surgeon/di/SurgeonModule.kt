package com.example.mysurgeon.surgeon.di

import com.example.mysurgeon.surgeon.repository.SurgeonRepository
import com.example.mysurgeon.surgeon.repository.SurgeonRepositoryImpl
import com.example.mysurgeon.surgeon.view.SurgeonDetailsViewImpl
import dagger.Module
import dagger.Provides

@Module
class SurgeonModule {
    @Provides
    @SurgeonScope
    fun provideSurgeonRepository(surgeonRepositoryImpl: SurgeonRepositoryImpl): SurgeonRepository = surgeonRepositoryImpl
}