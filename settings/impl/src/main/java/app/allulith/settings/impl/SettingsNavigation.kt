package app.allulith.settings.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.navigation.api.Navigator
import app.allulith.settings.api.destinations.SettingsDestination
import app.allulith.settings.impl.destinations.settings.ui.SettingsRoute
import app.allulith.signup.api.destinations.SignUpDestination

internal fun EntryProviderScope<NavKey>.settingsNavigationBuilder(
    navigator: Navigator,
) {
    entry<SettingsDestination.Settings> {
        SettingsRoute(
            onBack = { navigator.pop() },
            navigateToRouting = { navigator.clearAndAddScreen(SignUpDestination.Welcome) },
        )
    }
}
