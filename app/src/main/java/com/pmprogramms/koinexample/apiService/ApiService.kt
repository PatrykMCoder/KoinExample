package com.pmprogramms.koinexample.apiService

import com.pmprogramms.koinexample.data.CatFact
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("facts/")
    fun getFacts(): Call<List<CatFact>>
}