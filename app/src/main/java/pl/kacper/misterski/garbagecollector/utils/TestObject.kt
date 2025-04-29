package pl.kacper.misterski.garbagecollector.utils

import android.util.Log
class TestObject(val name: String) {
    var bigArray: ByteArray = ByteArray(10 * 1024 * 1024) // 10 MB TODO K memory allocations


    init {
        Log.d("GC_TEST", "$name: Created")
    }
}