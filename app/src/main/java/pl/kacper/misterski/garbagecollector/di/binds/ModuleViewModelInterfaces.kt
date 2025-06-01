package pl.kacper.misterski.garbagecollector.di.binds

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import pl.kacper.misterski.garbagecollector.utils.TestObjectInterface
import pl.kacper.misterski.garbagecollector.utils.TestObjectInterfaceUnscopedViewModelScopedImpl
import pl.kacper.misterski.garbagecollector.utils.TestObjectInterfaceViewModelScopedImpl
import javax.inject.Named


@Module
@InstallIn(ViewModelComponent::class)
abstract class ModuleViewModelInterfaces {

    @Binds
    @ViewModelScoped
    @Named("ViewModel Binds")
    abstract fun bindViewModelObject(testObject: TestObjectInterfaceViewModelScopedImpl): TestObjectInterface

    @Binds
    @Named("Unscoped ViewModel Binds")
    abstract fun bindUnscopedSingletonObject(testObject: TestObjectInterfaceUnscopedViewModelScopedImpl): TestObjectInterface
}