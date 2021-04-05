package com.example.mysurgeon.procedure.di

import com.example.mysurgeon.procedure.repository.ProcedureRepository
import com.example.mysurgeon.procedure.repository.ProcedureRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class ProcedureModule {

    @ProcedureScope
    @Provides
    internal fun provideProcedureRepository(procedureRepositoryImpl: ProcedureRepositoryImpl): ProcedureRepository = procedureRepositoryImpl
}