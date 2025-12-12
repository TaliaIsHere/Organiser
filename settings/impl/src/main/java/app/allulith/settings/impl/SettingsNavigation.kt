package app.allulith.settings.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.navigation.api.Navigator
import app.allulith.settings.api.ui.SettingsDestination
import app.allulith.settings.impl.destinations.settings.ui.SettingsRoute

internal fun EntryProviderScope<NavKey>.settingsNavigationBuilder(
    navigator: Navigator,
) {
    entry<SettingsDestination.Settings> {
        SettingsRoute(
            onBack = { navigator.removeScreen() },
        )
    }
}
