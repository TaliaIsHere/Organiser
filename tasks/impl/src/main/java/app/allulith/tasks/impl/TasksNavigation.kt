package app.allulith.tasks.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.navigation.api.Navigator
import app.allulith.tasks.api.destinations.home.ui.TasksDestination
import app.allulith.tasks.impl.overview.ui.OverviewRoute

internal fun EntryProviderScope<NavKey>.tasksNavigationBuilder(
    navigator: Navigator,
) {
    entry<TasksDestination.Overview> {
        OverviewRoute()
    }
}
