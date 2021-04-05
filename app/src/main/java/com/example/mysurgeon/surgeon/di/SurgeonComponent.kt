package com.example.mysurgeon.surgeon.di

import com.example.mysurgeon.core.di.CoreComponent
import com.example.mysurgeon.surgeon.SurgeonViewModel
import dagger.Component

@SurgeonScope
@Component(modules = [SurgeonModule::class], dependencies = [CoreComponent::class])
interface SurgeonComponent {
    fun inject(viewModel: SurgeonViewModel)
}