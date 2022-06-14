package com.temper.jaydonga.jobs.view.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextAlign.Companion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.temper.jaydonga.R
import com.temper.jaydonga.jobs.model.Data
import com.temper.jaydonga.jobs.model.DummyData
import com.temper.jaydonga.jobs.model.currencyMap
import com.temper.jaydonga.jobs.view.ui.theme.TemperJayDongaTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun JobCard(
    data: Data,
) {
    Card(elevation = 5.dp) {
        Column {
            Box(modifier = Modifier.fillMaxSize()) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(data.job.project.client.links.hero_image)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.placeholder),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(top = 10.dp),
                    contentDescription = "Job image placeholder",
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    Text(
                        text = "${currencyMap[data.average_estimated_earnings_per_hour.currency]} ${data.average_estimated_earnings_per_hour.amount}",
                        modifier = Modifier
                            .padding(10.dp)
                            .background(color = Color.White),
                        textAlign = Companion.End,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
            Row {
                Text(
                    text = data.job.category.name,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                )
            }
            Text(
                text = data.job.project.client.registration_name,
                modifier = Modifier.padding(start = 10.dp, top = 5.dp),
                textAlign = TextAlign.Start,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "${formattedTime(data.earliest_possible_start_time)} - ${formattedTime(data.latest_possible_end_time)}",
                modifier = Modifier.padding(start = 10.dp, top = 5.dp, bottom = 10.dp),
                textAlign = TextAlign.Start,
                fontSize = 18.sp,
            )
        }
    }
}

val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH)
val outputFormat = SimpleDateFormat("HH:mm", Locale.ENGLISH)

private fun formattedTime(time: String): String {
    return outputFormat.format(inputFormat.parse(time) ?: Date())
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TemperJayDongaTheme {
        JobCard(data = DummyData.getJobsData().data[0])
    }
}

@Composable
fun BottomNavigationButtons(clickHandler: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 30.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Button(
            onClick = {
                clickHandler()
            },
            modifier = Modifier
                .width(150.dp)
                .width(50.dp)
        ) {
            Text(text = "Sign up")
        }
        Button(
            onClick = {
                clickHandler()
            },
            modifier = Modifier
                .width(150.dp)
                .width(50.dp)
        ) {
            Text(text = "Log in")
        }
    }
}