package com.kobayagi.airball

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform