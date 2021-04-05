package com.example.mysurgeon.journal.di

import com.example.mysurgeon.core.di.CoreComponent
import com.example.mysurgeon.journal.JournalViewModel
import dagger.Component

@JournalScope
@Component(modules = [JournalModule::class], dependencies = [CoreComponent::class])
interface JournalComponent {
    fun inject(viewModel: JournalViewModel)
}