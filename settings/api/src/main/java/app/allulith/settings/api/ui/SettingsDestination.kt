package app.allulith.settings.api.ui

import androidx.navigation3.runtime.NavKey

sealed class SettingsDestination : NavKey {
    data object Settings : SettingsDestination()
}