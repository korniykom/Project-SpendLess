package com.korniykom.spendless.screens.registration

sealed interface RegistrationActions {
    data class OnRegistrationNameInput(val name: String): RegistrationActions
}