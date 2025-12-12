package app.allulith.routing.api.ui

import androidx.navigation3.runtime.NavKey

sealed class RoutingDestination : NavKey {
    data object Routing : RoutingDestination()
}
