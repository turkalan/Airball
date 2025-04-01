package com.kobayagi.airball

import com.kobayagi.airball.core.firstModel.di.firstModelModule
import com.kobayagi.airball.feature.authorization.login.di.loginModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            firstModelModule,
            loginModule,
        )
    }
}