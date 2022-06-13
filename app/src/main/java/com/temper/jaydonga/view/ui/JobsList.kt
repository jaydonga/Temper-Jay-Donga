package com.temper.jaydonga.view.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.temper.jaydonga.view.ui.theme.TemperJayDongaTheme

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TemperJayDongaTheme {
        Greeting("Android")
    }
}