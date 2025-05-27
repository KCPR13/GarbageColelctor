package pl.kacper.misterski.garbagecollector.ui.second

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.kacper.misterski.garbagecollector.utils.LeakySingleton
import pl.kacper.misterski.garbagecollector.utils.TestObject
import pl.kacper.misterski.garbagecollector.utils.TestObjectInterface
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class SecondViewModel @Inject constructor(
    @Named("Singleton") val singletonObj: TestObject,
    @Named("Unscoped Singleton") val unscopedSingletonObj: TestObject,
    @Named("ViewModel Scoped") val viewModelScopedObj: TestObject,
    @Named("Unscoped ViewModel") val unscopedViewModelObj: TestObject,
    @Named("ViewModel Binds") val viewModelBindsObj: TestObjectInterface,
    @Named("Unscoped ViewModel Binds") val unscopedViewModelBindsObj: TestObjectInterface,
    @Named("Singleton Binds") val viewModelScopedBindsObj: TestObjectInterface,
    @Named("Unscoped Singleton Binds") val unscopedViewModelScopedBindsObj: TestObjectInterface,) : ViewModel() {
    val obj = TestObject("SecondViewModel object")

    init {
        Log.d("GC_TEST", "SecondViewModel init!")
    }

    fun createObjectWithContext(context: Context){
        LeakySingleton.leakyRef = TestObject("SecondViewModel object with context", context)
    }


    override fun onCleared() {
        super.onCleared()
        Log.d("GC_TEST", "SecondViewModel cleared!")
    }
}