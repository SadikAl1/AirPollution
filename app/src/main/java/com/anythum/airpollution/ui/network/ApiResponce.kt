package com.anythum.airpollution.ui.network


import com.google.gson.annotations.SerializedName


data class AirPollutionResponse(

    @SerializedName("co") var co: Double? = null,
    @SerializedName("no") var no: Double? = null,
    @SerializedName("no2") var no2: Double? = null,
    @SerializedName("o3") var o3: Double? = null,
    @SerializedName("so2") var so2: Double? = null,
    @SerializedName("pm2_5") var pm25: Double? = null,
    @SerializedName("pm10") var pm10: Double? = null,
    @SerializedName("nh3") var nh3: Double? = null

)

data class WeatherResponse(
    @SerializedName("coord") var coord: Coord? = Coord()

)

data class Coord(
    @SerializedName("lon") var lon: Double? = null,
    @SerializedName("lat") var lat: Double? = null,
)


