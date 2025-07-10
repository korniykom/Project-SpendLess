package com.korniykom.spendless.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface NavigationRoute : NavKey{
    @Serializable
    data object RegistrationFlow: NavigationRoute

    @Serializable
    data object RegistrationStartScreen: NavigationRoute
    @Serializable
    data object RegistrationPinScreen: NavigationRoute
    @Serializable
    data object RegistrationPinConfirmationScreen: NavigationRoute
    @Serializable
    data object RegistrationSetPreferencesScreen: NavigationRoute

    @Serializable
    data object LoginScreen: NavigationRoute
    @Serializable
    data object LoginPinScreen: NavigationRoute
}