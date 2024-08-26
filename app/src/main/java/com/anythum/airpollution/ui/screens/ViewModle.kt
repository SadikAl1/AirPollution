package com.anythum.airpollution.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.anythum.airpollution.ui.network.AirPollutionResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}

data class AirPollutionState(
    val status: Status = Status.LOADING,
    val result: AirPollutionResponse = AirPollutionResponse(),
    val error: String? = null

)

class PollutionViewModel : ViewModel() {

    private val _state = MutableStateFlow(AirPollutionState())
    val state = _state.asStateFlow()

    init {
        getAirPollution()
    }

    private fun getAirPollution() {
        viewModelScope.launch {
            try {
                val response = AirPollutionApi.retrofitService.getAirQuality(
                    lat = 26.50,
                    lon = 80.80,
                    apiKey = "0809f07c05815e65a3c0d4fad959ec14"
                )
                _state.update { it.copy(status = Status.SUCCESS, result = response) }
            } catch (e: Exception) {

                _state.update { it.copy(status = Status.ERROR, error = e.message) }
            }
        }

    }
}