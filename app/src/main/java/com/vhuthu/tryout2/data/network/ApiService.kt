package com.vhuthu.tryout2.data.network

import com.vhuthu.tryout2.data.ServerResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    companion object{
        val BASE_URL  = "http://agrifund.tech:8080/api/v1/"
    }

    @GET("farmers/farmer")
    suspend fun getDetails(): Response<ServerResponse>
}