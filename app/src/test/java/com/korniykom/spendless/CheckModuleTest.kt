package com.korniykom.spendless

import com.korniykom.spendless.di.appModule
import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.KoinTest
import org.koin.test.verify.verify

class CheckModuleTest : KoinTest {
    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun checkAllModules() {
        appModule.verify()
    }
}