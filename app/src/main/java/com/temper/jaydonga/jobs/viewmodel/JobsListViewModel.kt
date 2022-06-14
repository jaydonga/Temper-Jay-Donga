package com.temper.jaydonga.jobs.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.temper.jaydonga.jobs.model.Data
import com.temper.jaydonga.jobs.model.JobListRepository
import com.temper.jaydonga.network.ResultWrapper.GenericError
import com.temper.jaydonga.network.ResultWrapper.NetworkError
import com.temper.jaydonga.network.ResultWrapper.Success
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class JobsListViewModel(private val jobListRepository: JobListRepository): ViewModel() {

    private val jobSearchDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
    val apiErrorFlow = MutableStateFlow("")
    val jobListFlow = MutableStateFlow(emptyList<Data>())

    fun fetchJobsList(date: String = jobSearchDateFormat.format(Date())) {
        viewModelScope.launch {
            val jobsResponse = jobListRepository.getJobs(date)

            when (jobsResponse) {
                is Success -> {
                    jobListFlow.emit(jobsResponse.value)
                }
                is GenericError -> {
                    if (jobsResponse.error?.isNotEmpty() == true) {
                        apiErrorFlow.emit(jobsResponse.error)
                    }
                }
                is NetworkError -> {
                    if (jobsResponse.error.isNotEmpty()) {
                        apiErrorFlow.emit(jobsResponse.error)
                    }
                }
            }
        }
    }
}