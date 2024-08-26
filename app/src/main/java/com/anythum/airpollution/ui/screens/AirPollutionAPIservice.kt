package com.anythum.airpollution.ui.screens

import com.anythum.airpollution.ui.network.AirPollutionResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_URL = "https://api.openweathermap.org/data/2.5/air_pollution?"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface AirPollutionAPIservice {
    @GET("lat={lat}&lon={lon}&appid={apiKey}")
    suspend fun getAirQuality(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String,
    ): AirPollutionResponse
}

object AirPollutionApi {
    val retrofitService: AirPollutionAPIservice by lazy {
        retrofit.create(AirPollutionAPIservice::class.java)
    }
}