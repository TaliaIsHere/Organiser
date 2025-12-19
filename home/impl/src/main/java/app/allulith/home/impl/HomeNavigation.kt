package app.allulith.home.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.home.api.destinations.HomeDestination
import app.allulith.home.impl.destinations.home.ui.HomeRoute
import app.allulith.navigation.api.Navigator
import app.allulith.settings.api.destinations.SettingsDestination

internal fun EntryProviderScope<NavKey>.homeNavigationBuilder(
    navigator: Navigator,
) {
    entry<HomeDestination.Home> {
        HomeRoute(navigateToSettings = { navigator.addScreen(SettingsDestination.Settings) })
    }
}
