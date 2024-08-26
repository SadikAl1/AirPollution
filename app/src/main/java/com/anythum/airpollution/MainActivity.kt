package com.anythum.airpollution

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.anythum.airpollution.ui.screens.AirPollution
import com.anythum.airpollution.ui.screens.AirPollutionState
import com.anythum.airpollution.ui.screens.PollutionViewModel
import com.anythum.airpollution.ui.theme.AirPollutionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AirPollutionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AirPollution(
                        modifier = Modifier.padding(innerPadding),
                        state = AirPollutionState(),
                        onRefresh = { /*TODO*/ }
                    )
                }
            }
        }
    }
}

