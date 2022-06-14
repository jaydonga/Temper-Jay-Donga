package com.temper.jaydonga.jobs.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.temper.jaydonga.R
import com.temper.jaydonga.common.showToast
import com.temper.jaydonga.jobs.view.ui.BottomNavigationButtons
import com.temper.jaydonga.jobs.view.ui.JobCard
import com.temper.jaydonga.jobs.view.ui.theme.TemperJayDongaTheme
import com.temper.jaydonga.jobs.viewmodel.JobsListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class JobsListActivity : ComponentActivity() {

    private val viewModel: JobsListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.fetchJobsList()

        setContent {
            TemperJayDongaTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    val jobList = viewModel.jobListFlow.collectAsState().value
                    lifecycleScope.launchWhenCreated {
                        viewModel.apiErrorFlow.collect { errorMessage ->
                            if (errorMessage.isNotEmpty()) showToast(errorMessage)
                        }
                    }

                    Box {
                        LazyColumn {
                            items(jobList) { jobData ->
                                JobCard(data = jobData)
                            }
                        }
                        BottomNavigationButtons(
                            clickHandler = {
                                startActivity(Intent(applicationContext, BlankActivity::class.java))
                            },
                        )
                    }
                }
            }
        }
    }
}