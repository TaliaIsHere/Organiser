package app.allulith.home.impl

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.home.api.destinations.HomeDestination
import app.allulith.home.impl.destinations.home.ui.HomeRoute
import app.allulith.settings.api.destinations.SettingsDestination
import app.allulith.tasks.api.destinations.TasksDestination

internal fun EntryProviderScope<NavKey>.homeNavigationBuilder(
    backStack: SnapshotStateList<NavKey>,
) {
    entry<HomeDestination.Home> {
        HomeRoute(backStack = backStack)
    }
}
