package app.allulith.tasks.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.navigation.api.Navigator
import app.allulith.tasks.api.destinations.TasksDestination
import app.allulith.tasks.impl.destinations.overview.ui.OverviewRoute
import app.allulith.tasks.impl.destinations.taskCreation.ui.TaskCreationRoute

internal fun EntryProviderScope<NavKey>.tasksNavigationBuilder(
    navigator: Navigator,
) {
    entry<TasksDestination.Overview> {
        OverviewRoute(
            goBack = { navigator.pop() },
            navigateToTaskCreation = { task ->
                navigator.addScreen(TasksDestination.TaskCreation(task = task))
            },
        )
    }

    entry<TasksDestination.TaskCreation> {
        TaskCreationRoute(
            task = it.task,
            goBack = { navigator.pop() },
        )
    }
}
