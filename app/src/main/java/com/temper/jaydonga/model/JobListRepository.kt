package com.temper.jaydonga.model

import com.temper.jaydonga.network.ResultWrapper

interface JobListRepository {

    fun getJobs(date: String): ResultWrapper<List<Data>>
}