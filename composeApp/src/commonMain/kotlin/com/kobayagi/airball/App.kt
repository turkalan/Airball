package com.kobayagi.airball

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.kobayagi.airball.feature.authorization.login.view.LoginScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun App() {
    MaterialTheme {
        LoginScreen()
    }
}