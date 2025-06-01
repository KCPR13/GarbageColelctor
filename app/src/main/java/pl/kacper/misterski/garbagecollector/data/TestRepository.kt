package pl.kacper.misterski.garbagecollector.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class TestRepository {

    suspend fun fetchData() = withContext(kotlinx.coroutines.Dispatchers.IO) {
        delay(2000)
        "Fetched Data"
    }
}