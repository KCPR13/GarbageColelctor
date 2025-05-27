package pl.kacper.misterski.garbagecollector.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.kacper.misterski.garbagecollector.utils.TestObject
import pl.kacper.misterski.garbagecollector.utils.TestObjectInterface
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MainViewModel @Inject constructor(
    @Named("Singleton") val singletonObj: TestObject,
    @Named("Unscoped Singleton") val unscopedSingletonObj: TestObject,
    @Named("ViewModel Scoped") val viewModelScopedObj: TestObject,
    @Named("Unscoped ViewModel") val unscopedViewModelObj: TestObject,
    @Named("ViewModel Binds") val viewModelBindsObj: TestObjectInterface,
    @Named("Unscoped ViewModel Binds") val unscopedViewModelBindsObj: TestObjectInterface,
    @Named("Singleton Binds") val viewModelScopedBindsObj: TestObjectInterface,
    @Named("Unscoped Singleton Binds") val unscopedViewModelScopedBindsObj: TestObjectInterface,
) : ViewModel() {

    val obj = TestObject("MainViewModel object")


    init {
        Log.d("GC_TEST", "MainViewModel init!")
    }


    override fun onCleared() {
        super.onCleared()
        Log.d("GC_TEST", "MainViewModel cleared!")
    }
}