package pl.kacper.misterski.garbagecollector.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.kacper.misterski.garbagecollector.utils.TestObject
import pl.kacper.misterski.garbagecollector.utils.GcTracker
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MainViewModel @Inject constructor(
    @Named("Singleton") val singletonObj: TestObject,
    @Named("Unscoped Singleton") val unscopedSingletonObj: TestObject,
    @Named("ViewModel Scoped") val viewModelScopedObj: TestObject,
    @Named("Unscoped ViewModel") val unscopedViewModelObj: TestObject, ) : ViewModel() {


    init {
        Log.d("GC_TEST", "MainViewModel init!")
        GcTracker.track(singletonObj, "Singleton")
        GcTracker.track(unscopedSingletonObj, "Unscoped Singleton")
        GcTracker.track(viewModelScopedObj, "ViewModelScoped")
        GcTracker.track(unscopedViewModelObj, "Unscoped ViewModel")
    }


    override fun onCleared() {
        super.onCleared()
        Log.d("GC_TEST", "ViewModel cleared!")
    }
}