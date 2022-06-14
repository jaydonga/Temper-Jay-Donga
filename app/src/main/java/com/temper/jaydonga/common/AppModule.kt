package com.temper.jaydonga.common

import com.temper.jaydonga.jobs.model.JobListRepository
import com.temper.jaydonga.jobs.model.JobListRepositoryImpl
import com.temper.jaydonga.jobs.viewmodel.JobsListViewModel
import com.temper.jaydonga.network.ApiService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://temper.works")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    single<JobListRepository> {
        JobListRepositoryImpl(get())
    }

    viewModel { JobsListViewModel(get()) }
}