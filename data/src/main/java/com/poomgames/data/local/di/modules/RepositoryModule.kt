package com.poomgames.data.local.di.modules

import com.poomgames.data.repositories.DatabaseRepositoryImpl
import com.poomgames.data.repositories.SharedRepositoryImpl
import com.poomgames.domain.repositories.DatabaseRepository
import com.poomgames.domain.repositories.SharedRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {
    @Binds
    fun bindRepository(repositoryImpl: SharedRepositoryImpl): SharedRepository

    @Binds
    fun bindDatabaseRepository(databaseRepositoryImpl: DatabaseRepositoryImpl): DatabaseRepository
}