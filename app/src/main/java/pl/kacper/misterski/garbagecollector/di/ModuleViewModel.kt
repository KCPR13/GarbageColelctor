package pl.kacper.misterski.garbagecollector.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import pl.kacper.misterski.garbagecollector.utils.TestObject
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    @Named("ViewModel Scoped")
    fun provideViewModelScopedObject(): TestObject {
        return TestObject("ViewModelScoped")
    }

    @Provides
    @Named("Unscoped ViewModel")
    fun provideUnscopedObject(): TestObject {
        return TestObject("Unscoped ViewModel")
    }
}