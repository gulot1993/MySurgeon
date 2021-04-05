package com.example.mysurgeon.procedure.di

import com.example.mysurgeon.core.di.CoreComponent
import com.example.mysurgeon.procedure.ProcedureViewModel
import dagger.Component


@ProcedureScope
@Component(modules = [ProcedureModule::class],dependencies = [CoreComponent::class])
interface ProcedureComponent {
    fun inject(viewModel: ProcedureViewModel)
}