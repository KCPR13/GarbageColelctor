package pl.kacper.misterski.garbagecollector.utils

import android.content.Context
import android.util.Log
class TestObject(val name: String, val context: Context? = null) {
    var bigArray: ByteArray = ByteArray(10 * 1024 * 1024) // 10 MB


    init {
        Log.d("GC_TEST", "$name: Created")
    }
}