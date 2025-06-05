package pl.kacper.misterski.garbagecollector.core

import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Handler
import android.os.Looper
import dagger.hilt.android.HiltAndroidApp
import pl.kacper.misterski.garbagecollector.util.AppFileLogger
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltAndroidApp
class MainApplication : Application() {

    @Inject
    lateinit var appFileLogger: AppFileLogger

    private val handler = Handler(Looper.getMainLooper())

    private val logMemoryRunnable = object : Runnable {
        override fun run() {
            logHeapUsage()
            handler.postDelayed(this, TimeUnit.SECONDS.toMillis(2))
        }
    }

    override fun onCreate() {
        super.onCreate()

        appFileLogger.log(
            "GC_TEST",
            "=======================[APP START]========================="
        )
        appFileLogger.log(
            "GC_TEST",
            "Battery level: ${getBatteryLevel(this)}%"
        )
        // LINK https://developer.android.com/reference/android/app/ActivityManager#getMemoryClass()
        val activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        val memoryClass = activityManager.memoryClass
        val largeMemoryClass = activityManager.largeMemoryClass // używane gdy android:largeHeap="true" w manifeście


        appFileLogger.log(
            "GC_TEST",
            "memoryClass: ${memoryClass}MB | largeMemoryClass: ${largeMemoryClass}MB"
        )

        handler.post(logMemoryRunnable)
    }

    private fun logHeapUsage() {
        val runtime = Runtime.getRuntime()

        val usedMemInMB = (runtime.totalMemory() - runtime.freeMemory()) / 1048576L
        val maxHeapSizeInMB = runtime.maxMemory() / 1048576L

        appFileLogger.log(
            "GC_TEST",
            "[HEAP] Used: ${usedMemInMB}MB | Max: ${maxHeapSizeInMB}MB"
        )
    }

    override fun onTerminate() {
        super.onTerminate()
        handler.removeCallbacks(logMemoryRunnable)
    }

    fun getBatteryLevel(context: Context): Int {
        val ifilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val batteryStatus: Intent? = context.registerReceiver(null, ifilter)

        val level = batteryStatus?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) ?: -1
        val scale = batteryStatus?.getIntExtra(BatteryManager.EXTRA_SCALE, -1) ?: -1

        if (level == -1 || scale == -1) {
            return -1
        }

        return (level * 100) / scale
    }
}