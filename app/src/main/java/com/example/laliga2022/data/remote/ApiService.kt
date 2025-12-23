package com.example.laliga2022.data.remote

import com.example.laliga2022.data.model.StandingDto
import retrofit2.http.GET

interface ApiService {

    @GET(".")
    suspend fun getStandings(): List<StandingDto>
}
