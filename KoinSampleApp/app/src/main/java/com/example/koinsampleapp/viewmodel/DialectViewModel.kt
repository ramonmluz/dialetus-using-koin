package com.example.koinsampleapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koinsampleapp.model.Dialect
import com.example.koinsampleapp.repository.DialectRepository
import kotlinx.coroutines.launch

class DialectViewModel(private val dialectRepository: DialectRepository) : ViewModel() {

    private val dialects = MutableLiveData<List<Dialect>>()

    fun getDialects(): LiveData<List<Dialect>> = dialects

    fun loadDialects(region: String) {
        viewModelScope.launch {
            try {

                dialects.value = dialectRepository.loadDialect(region)

            } catch (e: Exception) {
                e.localizedMessage
            }
        }
    }
}