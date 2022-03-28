package com.example.appmasterdetail.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getRandomUsers(@Url url: String): Response<UserModel>
}