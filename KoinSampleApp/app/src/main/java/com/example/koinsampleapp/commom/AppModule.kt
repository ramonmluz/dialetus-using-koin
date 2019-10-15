package com.example.koinsampleapp.commom

import com.example.koinsampleapp.repository.DialectRepository
import com.example.koinsampleapp.viewmodel.DialectApi
import com.example.koinsampleapp.viewmodel.DialectViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {
    val DialectModule = module {
        single { DialectApi() }
        single { DialectRepository(get()) }
        viewModel { DialectViewModel(get()) }
    }
}