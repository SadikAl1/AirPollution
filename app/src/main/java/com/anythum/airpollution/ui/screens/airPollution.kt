package com.anythum.airpollution.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AirPollution(
    modifier: Modifier = Modifier,
    state: AirPollutionState,
    onRefresh: () -> Unit,
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp)
            .verticalScroll(rememberScrollState())
    )  {

        Row {
            Text(text = "Air Pollution ", fontSize = 30.sp,
                fontFamily = FontFamily.Monospace)
        }



        Text(text ="${state.result.no}")
        Text(text ="${state.result.no2}")
        Text(text ="${state.result.nh3}")
        Text(text ="${state.result.so2}")
        Text(text ="${state.result.co}")
        Text(text ="${state.result.o3}")
        Text(text ="${state.result.pm10}")


    }

}
