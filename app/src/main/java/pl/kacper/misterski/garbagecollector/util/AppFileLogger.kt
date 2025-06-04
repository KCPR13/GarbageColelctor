package pl.kacper.misterski.garbagecollector.util

import android.content.Context
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AppFileLogger(private val context: Context) {

    private val logFileName = "app_log.txt"
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault())

    private fun getLogFile(): File {
        val logDir = if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) {
            context.getExternalFilesDir(null)
        } else {
            context.filesDir
        }
        Log.d("FileLogger", "Log directory: ${logDir?.absolutePath}")

        return File(logDir, logFileName)
    }

    @Synchronized
    fun log(tag: String, message: String, level: LogLevel = LogLevel.INFO) {
        val timestamp = dateFormat.format(Date())
        val logMessage = "$timestamp [$level] $tag: $message\n"

        try {
            val logFile = getLogFile()
            val writer = FileWriter(logFile, true)
            writer.append(logMessage)
            writer.flush()
            writer.close()
        } catch (e: IOException) {
            Log.e("FileLogger", "Error writing log to file", e)
        }

        // Optional: Also log to Logcat
        when (level) {
            LogLevel.DEBUG -> Log.d(tag, message)
            LogLevel.INFO -> Log.i(tag, message)
            LogLevel.WARN -> Log.w(tag, message)
            LogLevel.ERROR -> Log.e(tag, message)
        }
    }

    enum class LogLevel {
        DEBUG, INFO, WARN, ERROR
    }
}