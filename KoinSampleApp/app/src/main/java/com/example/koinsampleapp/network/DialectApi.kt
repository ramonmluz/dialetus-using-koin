package com.example.koinsampleapp.viewmodel

import DialectApiDef
import com.example.koinsampleapp.model.Dialect
import com.example.koinsampleapp.model.Region
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class DialectApi {

    private val service: DialectApiDef

    init {
        // Cria interceptor para poder visualizar as requisições do retrofit no logCat
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        // Adiciona o interceptor ao Okhttp
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dialetus-service.herokuapp.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(httpClient.build())
            .build()

        service = retrofit.create(DialectApiDef::class.java)
    }

    suspend fun loadRegions(): List<Region> {
        return service.loadRegions()
    }

    suspend fun loadDialects(region: String): List<Dialect> {
        return service.loadDialects(region)
    }
}