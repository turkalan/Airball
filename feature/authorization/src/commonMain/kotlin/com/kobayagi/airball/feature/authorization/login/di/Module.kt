package com.kobayagi.airball.feature.authorization.login.di

import com.kobayagi.airball.feature.authorization.login.viewmodel.LoginViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val loginModule = module {
    viewModelOf(::LoginViewModel)
}