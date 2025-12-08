package app.allulith.signup.impl.destinations.accountCreation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.allulith.signup.impl.R
import app.allulith.ui.impl.components.textfields.OrganiserTextField
import app.allulith.ui.impl.templates.OrganiserScreen
import app.allulith.ui.impl.templates.OrganiserScreenAction
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
internal fun AccountCreationRoute(
    navigateToHome: () -> Unit,
    viewModel: AccountCreationViewModel = hiltViewModel(),
) {
    LaunchedEffect(Unit) {
        viewModel.eventsFlow.collect { event ->
            when (event) {
                AccountCreation.Event.NavigateToHome -> navigateToHome()
            }
        }
    }

    AccountCreationScreen(
        uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
        onUiEvent = viewModel::onUiEvent,
    )
}

@Composable
private fun AccountCreationScreen(
    uiState: AccountCreation.UiState,
    onUiEvent: (AccountCreation.UiEvent) -> Unit,
) {
    OrganiserScreen(
        header = stringResource(R.string.signup_account_creation_header),
        description = stringResource(R.string.signup_account_creation_description),
        primaryAction = OrganiserScreenAction(
            text = stringResource(R.string.signup_account_creation_button_text),
            onClick = {
                onUiEvent(AccountCreation.UiEvent.OnCreateAccountTap)
            },
        )
    ) {
        OrganiserTextField(
            text = uiState.name,
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(R.string.signup_account_creation_text_field_label),
            placeholder = stringResource(R.string.signup_account_creation_text_field_placeholder),
        )
    }
}

@PreviewLightDark
@Composable
private fun AccountCreationScreenPreview() {
    OrganiserTheme {
        AccountCreationScreen(
            uiState = AccountCreation.UiState(),
            onUiEvent = {},
        )
    }
}
