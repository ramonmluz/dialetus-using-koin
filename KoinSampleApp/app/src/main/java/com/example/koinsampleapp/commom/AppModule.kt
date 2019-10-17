package com.example.koinsampleapp.commom

import com.example.koinsampleapp.repository.DialectRepository
import com.example.koinsampleapp.viewmodel.DialectApi
import com.example.koinsampleapp.viewmodel.DialectViewModel
import com.example.koinsampleapp.viewmodel.RegionViewModel

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {

    val apiModule = module {
        single { DialectApi() }
    }

    val repositoryModule = module {
        single { DialectRepository(get()) }
    }

    val regionModule = module {
        viewModel { RegionViewModel(get()) }
    }

    val dialectModule = module {
        viewModel { DialectViewModel(get()) }
    }

}