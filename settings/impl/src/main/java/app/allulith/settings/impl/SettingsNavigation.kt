package app.allulith.settings.impl

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.settings.api.destinations.SettingsDestination
import app.allulith.settings.impl.destinations.settings.ui.SettingsRoute
import app.allulith.signup.api.destinations.SignUpDestination

internal fun EntryProviderScope<NavKey>.settingsNavigationBuilder(
    backStack: SnapshotStateList<NavKey>,
) {
    entry<SettingsDestination.Settings> {
        SettingsRoute(
            onBack = { backStack.removeLastOrNull() },
            navigateToRouting = {
                backStack.clear()
                backStack.add(SignUpDestination.Welcome)
            },
        )
    }
}
