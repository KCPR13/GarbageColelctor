package pl.kacper.misterski.garbagecollector.di.use_case

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import pl.kacper.misterski.garbagecollector.data.TestRepository
import pl.kacper.misterski.garbagecollector.use_case.TestUseCase
import pl.kacper.misterski.garbagecollector.util.AppFileLogger
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelUseCaseModule {

    @Provides
    @ViewModelScoped
    @Named("ViewModelScoped UseCase")
    fun bindViewModelScopedUseCase(appFileLogger: AppFileLogger,@Named("Singleton Repository") testRepository: TestRepository) =
        TestUseCase(
            testRepository,
            appFileLogger,
            "ViewModelScoped UseCase"
        )

    @Provides
    @Named("Unscoped ViewModelScope UseCase")
    fun bindUnscopedViewModelScopedUseCase(appFileLogger: AppFileLogger, @Named("Singleton Repository") testRepository: TestRepository) =
        TestUseCase(
            testRepository,
            appFileLogger,
            "Unscoped ViewModelScope UseCase"
        )


}