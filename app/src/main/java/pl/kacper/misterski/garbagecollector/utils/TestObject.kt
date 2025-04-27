package pl.kacper.misterski.garbagecollector.utils

import android.util.Log
class TestObject(val name: String) {
    var bigArray: ByteArray = ByteArray(10 * 1024 * 1024) // 100 MB


    init {
        Log.d("GC_TEST", "$name: Created")
    }
}