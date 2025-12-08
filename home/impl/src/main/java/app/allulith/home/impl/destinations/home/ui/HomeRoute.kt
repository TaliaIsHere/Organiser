package app.allulith.home.impl.destinations.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import app.allulith.ui.impl.templates.OrganiserScreen
import app.allulith.ui.impl.templates.OrganiserScreenAction
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
internal fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    HomeScreen()
}

@Composable
private fun HomeScreen() {
    OrganiserScreen(
        header = "Hello Nota!",
        description = "Lorem ipsum",
    ) {

    }
}

@PreviewLightDark
@Composable
private fun HomeScreenPreview() {
    OrganiserTheme {
        HomeScreen()
    }
}
