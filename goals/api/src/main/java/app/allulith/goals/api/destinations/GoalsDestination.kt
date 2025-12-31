package app.allulith.goals.api.destinations

import androidx.navigation3.runtime.NavKey

sealed class GoalsDestination : NavKey {
    data object Overview : GoalsDestination()
}
