package com.kobayagi.airball.core.firstModel.domain.contract

import com.kobayagi.airball.common.core.errorhandling.Either
import com.kobayagi.airball.common.core.errorhandling.Error
import com.kobayagi.airball.core.firstModel.domain.model.contract.FirstModel

interface FirstModelUseCase {
    suspend fun getFirstModel(): Either<Error, FirstModel>
}