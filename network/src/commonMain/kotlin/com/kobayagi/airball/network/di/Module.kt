package com.kobayagi.airball.network.di

import com.kobayagi.airball.core.firstModel.data.datasource.remote.FirstModelRemoteDataSource
import com.kobayagi.airball.network.factory.HttpClientFactory
import com.kobayagi.airball.network.remotedatasourceimpl.first.FirstRemoteDataSourceImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val networkModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::FirstRemoteDataSourceImpl).bind<FirstModelRemoteDataSource>()
}