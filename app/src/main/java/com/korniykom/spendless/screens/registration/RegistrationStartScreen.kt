package com.korniykom.spendless.screens.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.korniykom.spendless.R
import com.korniykom.spendless.theme.SpendLessTheme

@Composable
fun RegistrationStartScreenRoot(
    onNextButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: RegistrationViewModel,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    RegistrationStartScreen(
        state = state,
        onNextButtonClick = onNextButtonClick,
        onNameInput = { viewModel.onAction(RegistrationActions.OnRegistrationNameInput(it)) },
        modifier = modifier
    )
}

@Composable
fun RegistrationStartScreen(
    state: RegistrationState,
    onNameInput: (String) -> Unit,
    onNextButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(26.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(R.drawable.spendless_icon),
            contentDescription = "SpendLess icon",
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Welcome to SpendLess!\nHow can we address you?",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Create unique username",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(36.dp))
        OutlinedTextField(
            placeholder = {
                Text(
                    text = "username", style = MaterialTheme.typography.displayMedium.copy(
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = .36f)
                    ), modifier = Modifier.fillMaxWidth()
                )
            },
            singleLine = true,
            value = state.nameInput,
            onValueChange = { onNameInput(it) },
            modifier = Modifier
                .fillMaxWidth(),
            textStyle = MaterialTheme.typography.displayMedium.copy(
                textAlign = TextAlign.Center
            ),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Transparent,
                unfocusedContainerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = .08f),
                focusedContainerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = .08f)j
            ),
            shape = RoundedCornerShape(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onNextButtonClick,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                text = "Next",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
        Spacer(modifier = Modifier.height(28.dp))
        Text(
            text = "Already have an account?",
            style = MaterialTheme.typography.titleMedium.copy(
                color = MaterialTheme.colorScheme.primary
            )
        )
    }
}

@Preview
@Composable
private fun RegistrationStartScreenPreview() {
    SpendLessTheme {
        RegistrationStartScreen(
            onNextButtonClick = {},
            state = RegistrationState(nameInput = "Max"),
            onNameInput = {},
        )
    }
}