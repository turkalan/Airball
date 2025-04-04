package com.kobayagi.airball.network.remotedatasourceimpl.first

import com.kobayagi.airball.common.core.errorhandling.Either
import com.kobayagi.airball.common.core.errorhandling.Either.Companion.success
import com.kobayagi.airball.common.core.errorhandling.Error
import com.kobayagi.airball.core.firstModel.data.datasource.remote.FirstModelRemoteDataSource
import com.kobayagi.airball.core.firstModel.domain.model.contract.FirstModel
import com.kobayagi.airball.network.model.first.FirstRemoteModel
import io.ktor.client.HttpClient

class FirstRemoteDataSourceImpl(
    private val httpClient: HttpClient
): FirstModelRemoteDataSource {
    override suspend fun getData(): Either<Error, FirstModel> {
        return success(FirstRemoteModel(1, "Lala", "Lala"))
//        return safeCall<FirstModel> {
//            httpClient.get(
//                urlString = "test",
//            ) {
//                parameter("test", "test")
//            }
//        }
    }
}