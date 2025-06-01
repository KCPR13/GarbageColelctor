package pl.kacper.misterski.garbagecollector.di.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.kacper.misterski.garbagecollector.data.SingletonTestRepositoryImpl
import pl.kacper.misterski.garbagecollector.data.TestRepository
import pl.kacper.misterski.garbagecollector.data.UnscopedSingletonTestRepositoryImpl
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SingletonRepositoryModule {

    @Binds
    @Singleton
    @Named("Singleton Repository")
    abstract fun bindSingletonTestRepository(repository: SingletonTestRepositoryImpl): TestRepository

    @Binds
    @Named("Unscoped Repository")
    abstract fun bindUnscopedSingletonTestRepository(repository: UnscopedSingletonTestRepositoryImpl): TestRepository
}
