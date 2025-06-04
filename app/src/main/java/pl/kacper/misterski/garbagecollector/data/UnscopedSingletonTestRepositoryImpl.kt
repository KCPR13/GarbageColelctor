package pl.kacper.misterski.garbagecollector.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import pl.kacper.misterski.garbagecollector.util.AppFileLogger
import javax.inject.Inject

class UnscopedSingletonTestRepositoryImpl @Inject constructor(private val appFileLogger: AppFileLogger): TestRepository {
    var bigArray: ByteArray = ByteArray(10 * 1024 * 1024) // 10 MB

    init {
        appFileLogger.log("GC_TEST", "[BINDS] Unscoped Singleton TestRepository: Created")
    }

    override suspend fun fetchData() = withContext(Dispatchers.IO) {
        delay(2000)
        "Fetched Data"
    }
}