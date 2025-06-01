package pl.kacper.misterski.garbagecollector.di.binds

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.kacper.misterski.garbagecollector.utils.TestObjectInterface
import pl.kacper.misterski.garbagecollector.utils.TestObjectInterfaceSingletonImpl
import pl.kacper.misterski.garbagecollector.utils.TestObjectInterfaceSingletonUnscopedImpl
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ModuleSingletonInterfaces {

    @Binds
    @Singleton
    @Named("Singleton Binds")
    abstract fun bindSingletonObject(testObject: TestObjectInterfaceSingletonImpl): TestObjectInterface

    @Binds
    @Named("Unscoped Singleton Binds")
    abstract fun bindUnscopedSingletonObject(testObject: TestObjectInterfaceSingletonUnscopedImpl): TestObjectInterface
}