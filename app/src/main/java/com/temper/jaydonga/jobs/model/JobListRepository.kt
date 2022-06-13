package com.temper.jaydonga.jobs.model

import com.temper.jaydonga.network.ResultWrapper

interface JobListRepository {

    fun getJobs(date: String): ResultWrapper<List<Data>>
}