package app.allulith.home.impl.destinations.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.allulith.home.impl.R
import app.allulith.ui.impl.templates.OrganiserScreen
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
internal fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    HomeScreen(
        uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
    )
}

@Composable
private fun HomeScreen(
    uiState: Home.UiState,
) {
    OrganiserScreen(
        header = stringResource(R.string.home_header, uiState.name),
        description = stringResource(R.string.home_description),
    ) {

    }
}

@PreviewLightDark
@Composable
private fun HomeScreenPreview() {
    OrganiserTheme {
        HomeScreen(
            uiState = Home.UiState(
                name = "Nota Areal",
            )
        )
    }
}
