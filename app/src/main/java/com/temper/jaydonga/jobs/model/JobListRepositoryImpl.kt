package com.temper.jaydonga.jobs.model

import com.temper.jaydonga.network.ApiService
import com.temper.jaydonga.network.ResultWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class JobListRepositoryImpl(
    private val jobListListRemoteDataSource: ApiService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
): JobListRepository {

    override fun getJobs(date: String): ResultWrapper<List<Data>> {
        TODO("Not yet implemented")
    }
}