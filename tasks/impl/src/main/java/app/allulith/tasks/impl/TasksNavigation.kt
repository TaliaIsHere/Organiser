package app.allulith.tasks.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.navigation.api.Navigator
import app.allulith.tasks.api.destinations.TasksDestination
import app.allulith.tasks.impl.destinations.overview.ui.OverviewRoute

internal fun EntryProviderScope<NavKey>.tasksNavigationBuilder(
    navigator: Navigator,
) {
    entry<TasksDestination.Overview> {
        OverviewRoute(
            goBack = { navigator.removeScreen() },
            navigateToTaskCreation = { navigator.addScreen(TasksDestination.TaskCreation) },
        )
    }

    entry<TasksDestination.Overview> {
        TODO()
    }
}
