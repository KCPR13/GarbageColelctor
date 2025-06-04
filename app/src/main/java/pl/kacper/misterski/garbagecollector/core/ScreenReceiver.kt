package pl.kacper.misterski.garbagecollector.core

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import dagger.hilt.android.AndroidEntryPoint
import pl.kacper.misterski.garbagecollector.util.AppFileLogger
import javax.inject.Inject

@AndroidEntryPoint
class ScreenReceiver : BroadcastReceiver() {


    @Inject
    lateinit var appFileLogger: AppFileLogger

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_SCREEN_ON -> {
                appFileLogger.log("GC_TEST", "Screen ON")
            }
            Intent.ACTION_SCREEN_OFF -> {
                appFileLogger.log("GC_TEST", "Screen OFF")
            }
        }
    }
}