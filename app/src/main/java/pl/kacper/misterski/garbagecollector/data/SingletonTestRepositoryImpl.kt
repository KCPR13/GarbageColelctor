package pl.kacper.misterski.garbagecollector.data

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import pl.kacper.misterski.garbagecollector.util.AppFileLogger
import javax.inject.Inject

class SingletonTestRepositoryImpl @Inject constructor(private val appFileLogger: AppFileLogger): TestRepository {
    var bigArray: ByteArray = ByteArray(10 * 1024 * 1024) // 10 MB


    init {
        appFileLogger.log("GC_TEST", "[BINDS] Singleton TestRepository: Created")
    }

    override suspend fun fetchData() = withContext(kotlinx.coroutines.Dispatchers.IO) {
        delay(2000)
        "Fetched Data"
    }
}