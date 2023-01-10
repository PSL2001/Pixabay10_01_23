package com.example.pixabay10_01_23.apiProvider

import com.example.pixabay10_01_23.models.Pixabay
import retrofit2.http.GET

interface ApiService {
    @GET("api/")

    suspend fun getImages(): Pixabay
}