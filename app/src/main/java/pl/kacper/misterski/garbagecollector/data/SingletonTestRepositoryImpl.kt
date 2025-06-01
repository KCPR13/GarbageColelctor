package pl.kacper.misterski.garbagecollector.data

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SingletonTestRepositoryImpl @Inject constructor(): TestRepository {
    var bigArray: ByteArray = ByteArray(10 * 1024 * 1024) // 10 MB


    init {
        Log.d("GC_TEST", "[BINDS] Singleton TestRepository: Created")
    }

    override suspend fun fetchData() = withContext(kotlinx.coroutines.Dispatchers.IO) {
        delay(2000)
        "Fetched Data"
    }
}