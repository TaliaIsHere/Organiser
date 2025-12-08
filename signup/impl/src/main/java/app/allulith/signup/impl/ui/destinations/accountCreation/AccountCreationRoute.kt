package app.allulith.signup.impl.ui.destinations.accountCreation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.signup.impl.R
import app.allulith.ui.impl.components.textfields.OrganiserTextField
import app.allulith.ui.impl.templates.OrganiserScreen
import app.allulith.ui.impl.templates.OrganiserScreenAction
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
internal fun AccountCreationRoute(
    onContinue: () -> Unit,
) {
    AccountCreationScreen(onContinue = onContinue)
}

@Composable
private fun AccountCreationScreen(
    onContinue: () -> Unit,
) {
    OrganiserScreen(
        header = stringResource(R.string.signup_account_creation_header),
        description = stringResource(R.string.signup_account_creation_description),
        primaryAction = OrganiserScreenAction(
            text = stringResource(R.string.signup_account_creation_button_text),
            onClick = onContinue,
        )
    ) {
        OrganiserTextField(
            text = "",
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
            onContinue = {},
        )
    }
}
