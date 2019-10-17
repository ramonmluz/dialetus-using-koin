package com.example.koinsampleapp.repository

import com.example.koinsampleapp.model.Dialect
import com.example.koinsampleapp.model.Region
import com.example.koinsampleapp.viewmodel.DialectApi

class DialectRepository(private val dialectApi: DialectApi) {

    suspend fun loadRegions(): List<Region> {
        return dialectApi.loadRegions()
    }

    suspend fun loadDialect(region: String): List<Dialect> {
        return dialectApi.loadDialects(region)
    }
}