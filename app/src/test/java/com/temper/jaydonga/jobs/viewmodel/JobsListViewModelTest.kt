package com.temper.jaydonga.jobs.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.temper.jaydonga.CoroutineTestRule
import com.temper.jaydonga.jobs.model.DummyData
import com.temper.jaydonga.jobs.model.JobListRepository
import com.temper.jaydonga.network.ResultWrapper
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.*
import org.junit.Assert.*

@ExperimentalCoroutinesApi
class JobsListViewModelTest {

    private lateinit var viewModel: JobsListViewModel
    @get:Rule
    val instantRule = InstantTaskExecutorRule()
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
    private val repository: JobListRepository = mockk()

    @Before
    fun setup() {
        viewModel = JobsListViewModel(repository)
    }

    @Test
    fun `successful response from API`() = runTest {
        coEvery { repository.getJobs(any()) } returns ResultWrapper.Success(DummyData.getJobsData().data)
        viewModel.fetchJobsList("2022-01-01")
        assertEquals(DummyData.getJobsData().data, viewModel.jobListFlow.first())
    }

    @Test
    fun `Generic Error response from API`() = runTest {
        coEvery { repository.getJobs(any()) } returns ResultWrapper.GenericError(code = 404, error = GENERIC_ERROR)
        viewModel.fetchJobsList("2022-01-01")
        assertEquals(GENERIC_ERROR, viewModel.apiErrorFlow.first())
    }

    @Test
    fun `NetworkError Error response from API`() = runTest {
        coEvery { repository.getJobs(any()) } returns ResultWrapper.NetworkError(NETWORK_ERROR)
        viewModel.fetchJobsList("2022-01-01")
        assertEquals(NETWORK_ERROR, viewModel.apiErrorFlow.first())
    }

    companion object {
        private const val GENERIC_ERROR = "Invalid data"
        private const val NETWORK_ERROR = "Not connected to Internet"
    }
}