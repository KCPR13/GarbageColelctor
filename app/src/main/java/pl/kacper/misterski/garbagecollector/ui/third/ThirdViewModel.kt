package pl.kacper.misterski.garbagecollector.ui.third

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.kacper.misterski.garbagecollector.use_case.TestUseCase
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class ThirdViewModel @Inject constructor(
    private val appFileLogger: pl.kacper.misterski.garbagecollector.util.AppFileLogger,
    @Named("Singleton UseCase") private val singletonTestUseCase: TestUseCase,
    @Named("Unscoped Singleton UseCase") private val singletonUscopedTestUseCase: TestUseCase,
    @Named("ViewModelScoped UseCase") private val viewmodelScopedTestUseCase: TestUseCase,
    @Named("Unscoped ViewModelScope UseCase") private val unscopedViewmodelScopedTestUseCase: TestUseCase,
) : ViewModel() {

    init {
        appFileLogger.log("GC_TEST", "ThirdViewModel init!")
    }


    override fun onCleared() {
        super.onCleared()
        appFileLogger.log("GC_TEST", "ThirdViewModel cleared!")
    }

    fun log(Tag: String, message: String) {
        appFileLogger.log(Tag, message)
    }
}
