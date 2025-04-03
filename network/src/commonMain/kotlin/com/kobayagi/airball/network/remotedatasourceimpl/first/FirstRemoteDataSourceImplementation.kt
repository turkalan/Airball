package com.kobayagi.airball.network.remotedatasourceimpl.first

import com.kobayagi.airball.core.firstModel.data.datasource.remote.FirstModelRemoteDataSource
import io.ktor.client.HttpClient

class FirstRemoteDataSourceImplementation(
    private val httpClient: HttpClient
): FirstModelRemoteDataSource {
}