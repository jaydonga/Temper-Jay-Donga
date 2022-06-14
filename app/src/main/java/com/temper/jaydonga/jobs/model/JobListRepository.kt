package com.temper.jaydonga.jobs.model

import com.temper.jaydonga.network.ResultWrapper

interface JobListRepository {

    suspend fun getJobs(date: String): ResultWrapper<List<Data>>
}