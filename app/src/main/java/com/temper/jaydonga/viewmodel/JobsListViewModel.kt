package com.temper.jaydonga.viewmodel

import androidx.lifecycle.ViewModel
import com.temper.jaydonga.model.JobListRepository
import com.temper.jaydonga.network.ResultWrapper.GenericError
import com.temper.jaydonga.network.ResultWrapper.NetworkError
import com.temper.jaydonga.network.ResultWrapper.Success

class JobsListViewModel(private val jobListRepository: JobListRepository): ViewModel() {



    fun fetchJobsList(date: String) {
        val jobsResponse = jobListRepository.getJobs(date)

        when (jobsResponse) {
            is Success -> TODO()
            is GenericError -> TODO()
            NetworkError -> TODO()
        }
    }

}