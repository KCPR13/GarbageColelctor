package pl.kacper.misterski.garbagecollector.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UnscopedSingletonTestRepositoryImpl @Inject constructor(): TestRepository {
    var bigArray: ByteArray = ByteArray(10 * 1024 * 1024) // 10 MB

    init {
        Log.d("GC_TEST", "[BINDS] Unscoped Singleton TestRepository: Created")
    }

    override suspend fun fetchData() = withContext(Dispatchers.IO) {
        delay(2000)
        "Fetched Data"
    }
}