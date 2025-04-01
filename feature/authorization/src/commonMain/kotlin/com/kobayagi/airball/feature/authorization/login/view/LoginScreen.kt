package com.kobayagi.airball.feature.authorization.login.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kobayagi.airball.common.compose.designsystem.AppColors.Black
import com.kobayagi.airball.feature.authorization.login.viewmodel.LoginState
import com.kobayagi.airball.feature.authorization.login.viewmodel.LoginViewModel
import com.kobayagi.airball.feature.authorization.login.viewmodel.LoginAction

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LoginScreenContent(
        state = state,
        onAction = { action ->
            viewModel::onAction
        }
    )
}

@Composable
private fun LoginScreenContent(
    state: LoginState,
    onAction: (LoginAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
       modifier = modifier.fillMaxSize(),
       contentAlignment = Alignment.Center,
    ) {
        Text(
            text = state.first,
            color = Black,
        )
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
}