package com.korniykom.spendless.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.korniykom.spendless.screens.login.LoginPinScreen
import com.korniykom.spendless.screens.login.LoginScreen
import com.korniykom.spendless.screens.registration.RegistrationPinConfirmationScreen
import com.korniykom.spendless.screens.registration.RegistrationPinScreen
import com.korniykom.spendless.screens.registration.RegistrationSetPreferencesScreen
import com.korniykom.spendless.screens.registration.RegistrationStartScreen

@Composable
fun NavigationRoot(
    isFirstLaunch: Boolean,
    modifier: Modifier = Modifier
) {
    val backStack = rememberNavBackStack<NavigationRoute>(
        if(isFirstLaunch) {
            NavigationRoute.RegistrationStartScreen
        } else {
            NavigationRoute.LoginScreen
        }
    )
    NavDisplay(
        backStack = backStack,
        onBack = {},
        entryDecorators = listOf(
            rememberSceneSetupNavEntryDecorator(),
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<NavigationRoute.RegistrationStartScreen> {
                RegistrationStartScreen()
            }
            entry<NavigationRoute.RegistrationPinScreen> {
                RegistrationPinScreen()
            }
            entry<NavigationRoute.RegistrationPinConfirmationScreen> {
                RegistrationPinConfirmationScreen()
            }
            entry<NavigationRoute.RegistrationSetPreferencesScreen> {
                RegistrationSetPreferencesScreen()
            }
            entry<NavigationRoute.LoginScreen> {
                LoginScreen()
            }
            entry<NavigationRoute.LoginPinScreen> {
                LoginPinScreen()
            }
        },
        modifier = modifier
    )
}