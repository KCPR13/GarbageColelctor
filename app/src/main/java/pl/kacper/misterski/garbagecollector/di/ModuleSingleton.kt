package pl.kacper.misterski.garbagecollector.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.kacper.misterski.garbagecollector.utils.TestObject
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object SingletonModule {

    @Provides
    @Singleton
    @Named("Singleton")
    fun provideSingletonObject(): TestObject {
        return TestObject("Singleton")
    }

    @Provides
    @Named("Unscoped Singleton")
    fun provideUnscopedObject(): TestObject {
        return TestObject("Unscoped Singleton")
    }
}

