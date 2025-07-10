package com.korniykom.spendless.screens.registration

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun RegistrationPinScreen(
    viewModel: RegistrationViewModel,
    modifier: Modifier = Modifier
) {
   val state by viewModel.state.collectAsStateWithLifecycle()
    Text(state.nameInput)
}