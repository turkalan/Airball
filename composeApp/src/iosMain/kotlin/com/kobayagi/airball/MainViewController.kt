package com.kobayagi.airball

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }