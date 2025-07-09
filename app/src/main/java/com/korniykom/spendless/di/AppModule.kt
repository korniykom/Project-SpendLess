package com.korniykom.spendless.di

import com.korniykom.spendless.screens.login.LoginViewModel
import com.korniykom.spendless.screens.registration.RegistrationViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val appModule = module {
    viewModelOf(::LoginViewModel)
    viewModelOf(::RegistrationViewModel)
}