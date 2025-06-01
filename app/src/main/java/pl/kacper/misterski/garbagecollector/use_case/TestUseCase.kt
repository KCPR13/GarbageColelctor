package pl.kacper.misterski.garbagecollector.use_case

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import pl.kacper.misterski.garbagecollector.data.TestRepository

class TestUseCase(private val testRepository: TestRepository) {

    operator fun invoke() = flow {
        val result = testRepository.fetchData()
        emit(result)
    }.flowOn(Dispatchers.IO)
}