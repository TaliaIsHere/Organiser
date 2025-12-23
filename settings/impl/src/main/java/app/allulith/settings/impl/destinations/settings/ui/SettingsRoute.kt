package app.allulith.settings.impl.destinations.settings.ui

import android.content.ClipData
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ClipEntry
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavKey
import app.allulith.settings.impl.R
import app.allulith.ui.impl.components.appbars.OrganiserTopBar
import app.allulith.ui.impl.components.buttons.OrganiserButton
import app.allulith.ui.impl.templates.OrganiserScreen
import app.allulith.ui.impl.text.OrganiserBodyText
import app.allulith.ui.impl.text.OrganiserSubHeaderText
import app.allulith.ui.impl.theme.OrganiserTheme
import kotlinx.coroutines.launch

@Composable
internal fun SettingsRoute(
    backStack: SnapshotStateList<NavKey>,
    viewModel: SettingsViewModel = hiltViewModel(
        creationCallback = { factory: SettingsViewModel.Factory ->
            factory.create(backStack = backStack)
        },
    ),
) {
    SettingScreen(
        uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
        onUiEvent = viewModel::onUiEvent,
    )
}

@Composable
private fun SettingScreen(
    uiState: Settings.UiState,
    onUiEvent: (Settings.UiEvent) -> Unit,
) {
    OrganiserScreen(
        header = stringResource(R.string.settings_header),
        description = stringResource(R.string.settings_description),
        topBarContent = {
            OrganiserTopBar(
                onBack = { onUiEvent(Settings.UiEvent.OnBack) },
            )
        },
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(
                OrganiserTheme.dimensions.padding.small,
            ),
        ) {
            AccountSection(onUiEvent = onUiEvent)
            VersionTag(version = uiState.version)
        }
    }
}

@Composable
private fun AccountSection(
    onUiEvent: (Settings.UiEvent) -> Unit,
) {
    Column {
        OrganiserSubHeaderText(
            text = stringResource(R.string.setting_account_header),
        )
        Spacer(Modifier.height(OrganiserTheme.dimensions.padding.small))
        OrganiserBodyText(
            text = stringResource(R.string.setting_account_description),
        )
        Spacer(Modifier.height(OrganiserTheme.dimensions.padding.medium))
        DeleteButton(onClick = { onUiEvent(Settings.UiEvent.OnDeleteAccount) })
    }
}

@Composable
private fun DeleteButton(
    onClick: () -> Unit,
) {
    OrganiserButton(
        text = stringResource(R.string.setting_delete_button),
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        error = true,
    )
}

@Composable
private fun VersionTag(version: String) {
    val clipboard = LocalClipboard.current
    val coroutineScope = rememberCoroutineScope()

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        TextButton(
            onClick = {
                coroutineScope.launch {
                    clipboard.setClipEntry(
                        ClipEntry(
                            ClipData.newPlainText(
                                "version",
                                version,
                            )
                        )
                    )
                }
            },
        ) {
            OrganiserBodyText(text = version)
        }
    }
}

@PreviewLightDark
@Composable
private fun SettingScreenPreview() {
    OrganiserTheme {
        SettingScreen(
            uiState = Settings.UiState(
                version = "0.1.0-ALPHA",
            ),
            onUiEvent = {},
        )
    }
}
