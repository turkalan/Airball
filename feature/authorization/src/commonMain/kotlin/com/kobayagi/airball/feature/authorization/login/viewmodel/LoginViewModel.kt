package com.kobayagi.airball.feature.authorization.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kobayagi.airball.common.core.errorhandling.onError
import com.kobayagi.airball.common.core.errorhandling.onSuccess
import com.kobayagi.airball.core.firstModel.domain.contract.FirstModelUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val useCase: FirstModelUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state = _state
        .onStart {
            fetchInitialData()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.Companion.WhileSubscribed(5_000L), //TODO("Set as constant, not hardcode it")
            _state.value,
        )

    fun onAction(action: LoginAction) {
        when (action) {
            //TODO("Add remaining conditions")
            else -> Unit
        }
    }

    private fun fetchInitialData() {
        viewModelScope.launch {
            useCase.getFirstModel()
                .onSuccess { data ->
                    _state.update { it.copy(first = data.name) }
                }
        }
    }
}