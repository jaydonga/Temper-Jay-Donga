package com.temper.jaydonga.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.temper.jaydonga.model.DummyData
import com.temper.jaydonga.view.ui.JobCard
import com.temper.jaydonga.view.ui.theme.TemperJayDongaTheme

class JobsListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemperJayDongaTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

                    LazyColumn {
                        items(DummyData.getJobsData().data) { data ->
                            JobCard(data = data)
                        }
                    }
                }
            }
        }
    }
}