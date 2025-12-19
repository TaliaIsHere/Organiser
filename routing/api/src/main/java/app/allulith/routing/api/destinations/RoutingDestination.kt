package app.allulith.routing.api.destinations

import androidx.navigation3.runtime.NavKey

sealed class RoutingDestination : NavKey {
    data object Routing : RoutingDestination()
}
