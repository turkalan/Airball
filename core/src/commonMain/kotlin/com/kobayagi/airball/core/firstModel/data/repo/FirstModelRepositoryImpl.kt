package com.kobayagi.airball.core.firstModel.data.repo

import com.kobayagi.airball.common.core.errorhandling.Either
import com.kobayagi.airball.common.core.errorhandling.Error
import com.kobayagi.airball.core.firstModel.domain.contract.FirstModelRepository
import com.kobayagi.airball.core.firstModel.domain.model.FirstDomainModel
import com.kobayagi.airball.core.firstModel.domain.model.contract.FirstModel

class FirstModelRepositoryImpl(

): FirstModelRepository {
    override fun getFirstModel(): Either<Error, FirstModel> {
        return Either.success(
            FirstDomainModel(
                id = 1,
                name = "Bla",
                surname = "Blu",
            )
        )
    }
}