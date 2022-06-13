package com.temper.jaydonga.view.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import com.temper.jaydonga.view.ui.theme.TemperJayDongaTheme

@Composable
fun Greeting(painter: Painter, jobThumbnailContentDesc: String) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Image(painter = painter, contentDescription = jobThumbnailContentDesc)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TemperJayDongaTheme {
    }
}