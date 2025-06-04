package pl.kacper.misterski.garbagecollector.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pl.kacper.misterski.garbagecollector.util.AppFileLogger
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoggerModule {

    @Provides
    @Singleton
    fun provideAppFileLogger(@ApplicationContext context: Context) =
        AppFileLogger(context = context)

}