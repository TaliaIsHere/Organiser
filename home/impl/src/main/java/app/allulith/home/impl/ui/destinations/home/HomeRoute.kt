package app.allulith.home.impl.ui.destinations.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.ui.impl.templates.OrganiserScreen
import app.allulith.ui.impl.templates.OrganiserScreenAction
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
internal fun HomeRoute(
    onContinue: () -> Unit,
) {
    HomeScreen(
        onContinue = onContinue,
    )
}

@Composable
private fun HomeScreen(
    onContinue: () -> Unit,
) {
    OrganiserScreen(
        header = "Hello Nota!",
        description = "Lorem ipsum",
        primaryAction = OrganiserScreenAction(
            text = "Proceed",
            onClick = onContinue,
        )
    ) {

    }
}

@PreviewLightDark
@Composable
private fun HomeScreenPreview() {
    OrganiserTheme {
        HomeScreen(
            onContinue = {},
        )
    }
}
