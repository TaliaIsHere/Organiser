package app.allulith.signup.impl.ui.destinations.accountCreation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
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
        header = "Time to create an account!",
        description = "TODO",
        primaryAction = OrganiserScreenAction(
            text = "Create",
            onClick = onContinue,
        )
    ) {

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
