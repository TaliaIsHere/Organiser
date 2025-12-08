package app.allulith.signup.impl.ui.destinations.welcome

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.ui.impl.templates.OrganiserScreen
import app.allulith.ui.impl.templates.OrganiserScreenAction
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
internal fun SignUpWelcomeRoute(
    onContinue: () -> Unit,
) {
    WelcomeScreen(onContinue = onContinue)
}

@Composable
private fun WelcomeScreen(
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
private fun WelcomeScreenPreview() {
    OrganiserTheme {
        WelcomeScreen(
            onContinue = {},
        )
    }
}
