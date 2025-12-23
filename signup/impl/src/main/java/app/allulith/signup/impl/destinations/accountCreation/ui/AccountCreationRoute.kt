package app.allulith.signup.impl.destinations.accountCreation.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavKey
import app.allulith.signup.impl.R
import app.allulith.ui.impl.components.textfields.OrganiserTextField
import app.allulith.ui.impl.templates.OrganiserScreen
import app.allulith.ui.impl.templates.OrganiserScreenAction
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
internal fun AccountCreationRoute(
    backStack: SnapshotStateList<NavKey>,
    viewModel: AccountCreationViewModel = hiltViewModel(
        creationCallback = { factory: AccountCreationViewModel.Factory ->
            factory.create(backStack = backStack)
        },
    ),
) {
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
                onUiEvent(AccountCreation.UiEvent.OnCreateAccount)
            },
        )
    ) {
        OrganiserTextField(
            text = uiState.name,
            onValueChange = { text ->
                onUiEvent(AccountCreation.UiEvent.OnNameChange(text = text))
            },
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(R.string.signup_account_creation_text_field_label),
            placeholder = stringResource(R.string.signup_account_creation_text_field_placeholder),
            isError = uiState.error,
            errorText = stringResource(R.string.signup_account_creation_text_field_error),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Done,
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    onUiEvent(AccountCreation.UiEvent.OnCreateAccount)
                },
            ),
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
