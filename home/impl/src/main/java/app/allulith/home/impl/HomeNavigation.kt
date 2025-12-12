package app.allulith.home.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.home.api.destinations.home.ui.HomeDestination
import app.allulith.home.impl.destinations.home.ui.HomeRoute

fun EntryProviderScope<NavKey>.homeNavigationBuilder() {
    entry<HomeDestination.Home> { key ->
        HomeRoute(navigateToSettings = key.navigateToSettings)
    }
}
