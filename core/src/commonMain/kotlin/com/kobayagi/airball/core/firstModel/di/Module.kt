package com.kobayagi.airball.core.firstModel.di

import com.kobayagi.airball.core.firstModel.data.repo.FirstModelRepositoryImpl
import com.kobayagi.airball.core.firstModel.domain.contract.FirstModelRepository
import com.kobayagi.airball.core.firstModel.domain.contract.FirstModelUseCase
import com.kobayagi.airball.core.firstModel.domain.usecase.FirstModelUseCaseImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val firstModelModule = module {
    singleOf(::FirstModelUseCaseImpl).bind<FirstModelUseCase>()
    singleOf(::FirstModelRepositoryImpl).bind<FirstModelRepository>()
}