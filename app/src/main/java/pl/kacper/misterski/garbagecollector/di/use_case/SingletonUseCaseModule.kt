package pl.kacper.misterski.garbagecollector.di.use_case

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.kacper.misterski.garbagecollector.data.TestRepository
import pl.kacper.misterski.garbagecollector.use_case.TestUseCase
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SingletonUseCaseModule {

    @Provides
    @Singleton
    @Named("Singleton UseCase")
    fun provideSingletonTestUseCase(@Named("Singleton Repository") testRepository: TestRepository) = TestUseCase(testRepository, "Singleton UseCase")

    @Provides
    @Named("Unscoped Singleton UseCase")
    fun provideUnscopedSingletonTestUseCase(@Named("Unscoped Repository") testRepository: TestRepository) = TestUseCase(
        testRepository,
        "Unscoped Singleton UseCase"
    )



}