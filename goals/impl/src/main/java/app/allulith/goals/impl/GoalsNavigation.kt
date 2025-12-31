package app.allulith.goals.impl

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.goals.api.destinations.GoalsDestination
import app.allulith.goals.impl.destinations.overview.ui.GoalsOverviewRoute

internal fun EntryProviderScope<NavKey>.goalsNavigationBuilder(
    backStack: SnapshotStateList<NavKey>,
) {

    entry<GoalsDestination.GoalsOverview> {
        GoalsOverviewRoute(backStack = backStack)
    }
}
