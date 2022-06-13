package com.temper.jaydonga.network

import com.temper.jaydonga.model.JobDataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/v3/shifts")
    fun getJobList(@Query("filter[date]") filterDate: String): Call<JobDataModel>

}