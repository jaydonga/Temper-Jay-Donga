package com.temper.jaydonga.jobs.model

import com.temper.jaydonga.network.ApiService
import com.temper.jaydonga.network.ResultWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class JobListRepositoryImpl(
    private val source: ApiService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
): JobListRepository {

    override suspend fun getJobs(date: String): ResultWrapper<List<Data>> {
        return withContext(dispatcher) {
            try {
                ResultWrapper.Success(source.getJobList(date).body()?.data ?: emptyList())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException -> ResultWrapper.NetworkError("Connectivity error")
                    else -> {
                        // This can be improved later
                        ResultWrapper.GenericError(throwable.hashCode(), throwable.message)
                    }
                }
            }
        }
    }
}