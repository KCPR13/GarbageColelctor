package pl.kacper.misterski.garbagecollector.data

interface TestRepository {
    suspend fun fetchData(): String
}

