package com.example.koinsampleapp.repository

import com.example.koinsampleapp.model.Region
import com.example.koinsampleapp.viewmodel.DialectApi

class DialectRepository(val dialectApi: DialectApi) {

    suspend fun loadRegions(): List<Region> {
        return dialectApi.loadRegions()
    }
}