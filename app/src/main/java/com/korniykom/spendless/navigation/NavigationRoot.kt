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
import com.korniykom.spendless.screens.registration.RegistrationStartScreenRoot
import com.korniykom.spendless.screens.registration.RegistrationViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavigationRoot(
    isFirstLaunch: Boolean,
    modifier: Modifier = Modifier,
) {
    val backStack = rememberNavBackStack<NavigationRoute>(
        if(isFirstLaunch) {
            NavigationRoute.RegistrationFlow
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
            entry<NavigationRoute.RegistrationFlow> {
                val registrationViewModel = koinViewModel<RegistrationViewModel>()
                val registrationBackstack = rememberNavBackStack<NavigationRoute>(
                    NavigationRoute.RegistrationStartScreen
                )
                NavDisplay(
                    backStack = registrationBackstack,
                    entryDecorators = listOf(
                        rememberSceneSetupNavEntryDecorator(),
                        rememberSavedStateNavEntryDecorator(),
                        rememberViewModelStoreNavEntryDecorator()
                    ),
                    onBack = {
                        registrationBackstack.removeLastOrNull()
                    },
                    entryProvider = entryProvider {
                        entry<NavigationRoute.RegistrationStartScreen> {
                            RegistrationStartScreenRoot(
                                viewModel = registrationViewModel,
                                onNextButtonClick = {
                                    registrationBackstack.add(NavigationRoute.RegistrationPinScreen)
                                },
                            )
                        }
                        entry<NavigationRoute.RegistrationPinScreen> {
                            RegistrationPinScreen(
                                viewModel = registrationViewModel
                            )
                        }
                        entry<NavigationRoute.RegistrationPinConfirmationScreen> {
                            RegistrationPinConfirmationScreen()
                        }
                        entry<NavigationRoute.RegistrationSetPreferencesScreen> {
                            RegistrationSetPreferencesScreen()
                        }
                    }
                )
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