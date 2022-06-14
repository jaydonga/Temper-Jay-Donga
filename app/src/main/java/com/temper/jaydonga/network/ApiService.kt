package com.temper.jaydonga.network

import com.temper.jaydonga.jobs.model.JobDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/v3/shifts")
    suspend fun getJobList(@Query("filter[date]") filterDate: String): Response<JobDataModel>

}