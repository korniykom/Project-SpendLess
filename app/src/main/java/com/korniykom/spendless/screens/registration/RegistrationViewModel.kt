package com.korniykom.spendless.screens.registration

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class RegistrationViewModel: ViewModel() {
    private val _state = MutableStateFlow(RegistrationState())
    val state = _state

    fun onAction(action: RegistrationActions) {
        when(action) {
            is RegistrationActions.OnRegistrationNameInput -> {
                _state.update {
                    it.copy(
                        nameInput = action.name
                    )
                }
            }
        }
    }
}