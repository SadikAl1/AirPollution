package com.anythum.airpollution.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun AirPollutionScreen1(modifier: Modifier = Modifier) {
    val coroutineScope = rememberCoroutineScope()
    var isLoading by remember { mutableStateOf(false) }
    var showData by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Heading
        Text(
            text = "Air Pollution",
            fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Button to fetch data
        Button(
            onClick = {
                isLoading = true
                showData = false
                coroutineScope.launch {
                    delay(2500)  // Simulate a 2-second delay
                    isLoading = false
                    showData = true  // Show data after delay
                }
            },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text("Fetch Air Quality Data")
        }

        // Show progress bar while loading
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.padding(bottom = 16.dp))
        }

        // Display data after loading is complete
        if (showData) {
            Column {
                Text(text = "Current Location - Lucknow ", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace)
                Text(text = "Air Quality Index: 3")
                Text(text = "CO: 201.0 µg/m3")
                Text(text = "NO: 0.1 µg/m3")
                Text(text = "NO2: 0.1 µg/m3")
                Text(text = "O3: 151.0 µg/m3")
                Text(text = "SO2: 1.0 µg/m3")
                Text(text = "PM2.5: 11.0 µg/m3")
                Text(text = "PM10: 16.0 µg/m3")
                Text(text = "NH3: 0.5 µg/m3")
            }
        }
    }
}
