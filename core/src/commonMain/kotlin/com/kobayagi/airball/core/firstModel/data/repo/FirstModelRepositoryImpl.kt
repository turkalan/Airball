package com.kobayagi.airball.core.firstModel.data.repo

import com.kobayagi.airball.common.core.errorhandling.Either
import com.kobayagi.airball.common.core.errorhandling.Either.Companion.success
import com.kobayagi.airball.common.core.errorhandling.Error
import com.kobayagi.airball.core.firstModel.data.datasource.remote.FirstModelRemoteDataSource
import com.kobayagi.airball.core.firstModel.domain.contract.FirstModelRepository
import com.kobayagi.airball.core.firstModel.domain.model.FirstDomainModel
import com.kobayagi.airball.core.firstModel.domain.model.contract.FirstModel

class FirstModelRepositoryImpl(
    private val remoteDataSource: FirstModelRemoteDataSource,
): FirstModelRepository {
    override suspend fun getFirstModel(): Either<Error, FirstModel> {
        return remoteDataSource.getData()
    }
}