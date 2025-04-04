package com.kobayagi.airball.core.firstModel.domain.usecase

import com.kobayagi.airball.common.core.errorhandling.Either
import com.kobayagi.airball.common.core.errorhandling.Error
import com.kobayagi.airball.core.firstModel.domain.contract.FirstModelRepository
import com.kobayagi.airball.core.firstModel.domain.contract.FirstModelUseCase
import com.kobayagi.airball.core.firstModel.domain.model.contract.FirstModel

class FirstModelUseCaseImpl(
    private val repository: FirstModelRepository,
): FirstModelUseCase {
    override suspend fun getFirstModel(): Either<Error, FirstModel> {
        return repository.getFirstModel()
    }
}