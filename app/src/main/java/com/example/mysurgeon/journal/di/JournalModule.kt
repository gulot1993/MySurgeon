package com.example.mysurgeon.journal.di

import com.example.mysurgeon.journal.repository.JournalRepository
import com.example.mysurgeon.journal.repository.JournalRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class JournalModule {

    @Provides
    @JournalScope
    internal fun provideJournalRepository(journalRepositoryImpl: JournalRepositoryImpl): JournalRepository = journalRepositoryImpl
}