package app.allulith.signup.impl.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.ui.impl.templates.OrganiserScreen
import app.allulith.ui.impl.templates.OrganiserScreenAction
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
fun SignUpRoute(
    onContinue: () -> Unit,
) {
    SignUpScreen(
        onContinue = onContinue,
    )
}

@Composable
private fun SignUpScreen(
    onContinue: () -> Unit,
) {
    OrganiserScreen(
        header = "Welcome to Organiser!",
        description = "There are a few things to set-up before we can start",
        primaryAction = OrganiserScreenAction(
            text = "Proceed",
            onClick = onContinue,
        )
    ) {

    }
}

@PreviewLightDark
@Composable
private fun SignUpScreenPreview() {
    OrganiserTheme {
        SignUpScreen(
            onContinue = {},
        )
    }
}
