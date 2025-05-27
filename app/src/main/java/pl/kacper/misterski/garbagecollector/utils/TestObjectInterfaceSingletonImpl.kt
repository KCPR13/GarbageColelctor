package pl.kacper.misterski.garbagecollector.utils

import android.util.Log
import javax.inject.Inject

class TestObjectInterfaceSingletonImpl @Inject constructor(): TestObjectInterface {

    var bigArray: ByteArray = ByteArray(10 * 1024 * 1024) // 10 MB

    var name: String = "TestObjectInterfaceSingletonImpl"

    init {
        Log.d("GC_TEST", "[BINDS] ${name}: Created")
    }
}

class TestObjectInterfaceSingletonUnscopedImpl @Inject constructor(): TestObjectInterface {

    var bigArray: ByteArray = ByteArray(10 * 1024 * 1024) // 10 MB

    var name: String = "TestObjectInterfaceSingletonUnscopedImpl"

    init {
        Log.d("GC_TEST", "[BINDS] ${name}: Created")
    }
}

class TestObjectInterfaceViewModelScopedImpl @Inject constructor(): TestObjectInterface {

    var bigArray: ByteArray = ByteArray(10 * 1024 * 1024) // 10 MB

    var name: String = "TestObjectInterfaceViewModelScopedImpl"

    init {
        Log.d("GC_TEST", "[BINDS] ${name}: Created")
    }

}

class TestObjectInterfaceUnscopedViewModelScopedImpl @Inject constructor(): TestObjectInterface {

    var bigArray: ByteArray = ByteArray(10 * 1024 * 1024) // 10 MB

    var name: String = "TestObjectInterfaceUnscopedViewModelScopedImpl"

    init {
        Log.d("GC_TEST", "[BINDS] ${name}: Created")
    }

}