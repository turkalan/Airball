package com.kobayagi.airball.core.firstModel.data.datasource.remote

import com.kobayagi.airball.common.core.errorhandling.Either
import com.kobayagi.airball.common.core.errorhandling.Error
import com.kobayagi.airball.core.firstModel.domain.model.contract.FirstModel

interface FirstModelRemoteDataSource {
    suspend fun getData(): Either<Error, FirstModel>
}