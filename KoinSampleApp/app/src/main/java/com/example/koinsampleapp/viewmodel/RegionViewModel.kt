package com.example.koinsampleapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koinsampleapp.model.Region
import com.example.koinsampleapp.repository.DialectRepository
import kotlinx.coroutines.launch

class RegionViewModel(private val dialectRepository: DialectRepository) : ViewModel() {

    private val regions = MutableLiveData<List<Region>>()

    fun getRegions(): LiveData<List<Region>> = regions

    fun loadRegions() {
        viewModelScope.launch {
            try {

                regions.value = dialectRepository.loadRegions()

            } catch (e: Exception) {
                e.localizedMessage
            }
        }
    }
}