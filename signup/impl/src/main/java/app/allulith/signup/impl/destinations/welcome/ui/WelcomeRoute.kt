package app.allulith.signup.impl.destinations.welcome.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.signup.impl.R
import app.allulith.ui.impl.templates.OrganiserScreen
import app.allulith.ui.impl.templates.OrganiserScreenAction
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
internal fun WelcomeRoute(
    onContinue: () -> Unit,
) {
    WelcomeScreen(onContinue = onContinue)
}

@Composable
private fun WelcomeScreen(
    onContinue: () -> Unit,
) {
    OrganiserScreen(
        header = stringResource(R.string.signup_welcome_header),
        description = stringResource(R.string.signup_welcome_description),
        primaryAction = OrganiserScreenAction(
            text = stringResource(R.string.signup_welcome_button_text),
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
