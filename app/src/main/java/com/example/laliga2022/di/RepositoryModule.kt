package com.example.laliga2022.di

import com.example.laliga2022.data.repo.StandingsRepository
import com.example.laliga2022.data.repo.StandingsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindStandingsRepository(
        impl: StandingsRepositoryImpl
    ): StandingsRepository
}
