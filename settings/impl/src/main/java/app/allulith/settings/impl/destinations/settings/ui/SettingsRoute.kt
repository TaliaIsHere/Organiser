package app.allulith.settings.impl.destinations.settings.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.allulith.settings.impl.R
import app.allulith.ui.impl.components.appbars.OrganiserTopBar
import app.allulith.ui.impl.templates.OrganiserScreen
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
internal fun SettingsRoute(
    viewModel: SettingsViewModel = hiltViewModel(),
    onBack: () -> Unit,
) {
    SettingScreen(
        uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
        onBack = onBack,
    )
}

@Composable
private fun SettingScreen(
    uiState: Settings.UiState,
    onBack: () -> Unit,
) {
    OrganiserScreen(
        header = stringResource(R.string.settings_header),
        description = stringResource(R.string.settings_description),
        topBarContent = {
            OrganiserTopBar(
                onBack = onBack,
            )
        },
    ) {

    }
}

@PreviewLightDark
@Composable
private fun SettingScreenPreview() {
    OrganiserTheme {
        SettingScreen(
            uiState = Settings.UiState,
            onBack = {},
        )
    }
}
