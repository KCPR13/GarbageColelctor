package pl.kacper.misterski.garbagecollector.core

import android.app.ActivityManager
import android.app.Application
import android.os.Handler
import android.os.Looper
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import java.util.concurrent.TimeUnit

@HiltAndroidApp
class MainApplication : Application() {

    private val handler = Handler(Looper.getMainLooper())

    private val logMemoryRunnable = object : Runnable {
        override fun run() {
            logHeapUsage()
            handler.postDelayed(this, TimeUnit.SECONDS.toMillis(5))
        }
    }

    override fun onCreate() {
        super.onCreate()
        // LINK https://developer.android.com/reference/android/app/ActivityManager#getMemoryClass()
        val activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        val memoryClass = activityManager.memoryClass
        val largeMemoryClass = activityManager.largeMemoryClass // używane gdy android:largeHeap="true" w manifeście
        Log.d(
            "GC_TEST",
            "memoryClass: ${memoryClass}MB | largeMemoryClass: ${largeMemoryClass}MB"
        )

        handler.post(logMemoryRunnable)
    }

    private fun logHeapUsage() {
        val runtime = Runtime.getRuntime()

        val usedMemInMB = (runtime.totalMemory() - runtime.freeMemory()) / 1048576L
        val maxHeapSizeInMB = runtime.maxMemory() / 1048576L

        Log.d(
            "GC_TEST",
            "[HEAP] Used: ${usedMemInMB}MB | Max: ${maxHeapSizeInMB}MB"
        )
    }

    override fun onTerminate() {
        super.onTerminate()
        handler.removeCallbacks(logMemoryRunnable)
    }
}