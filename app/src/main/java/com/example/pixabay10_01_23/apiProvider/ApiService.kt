package com.example.pixabay10_01_23.apiProvider

import com.example.pixabay10_01_23.models.Pixabay
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/")

    suspend fun getImages(@Query("key") key: String, @Query("q") q: String): Pixabay
}