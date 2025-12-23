package app.allulith.routing.impl

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.home.api.destinations.HomeDestination
import app.allulith.routing.api.destinations.RoutingDestination
import app.allulith.routing.impl.destinations.routing.ui.RoutingRoute
import app.allulith.signup.api.destinations.SignUpDestination

internal fun EntryProviderScope<NavKey>.routingNavigationBuilder(
    backStack: SnapshotStateList<NavKey>,
) {
    entry<RoutingDestination.Routing> {
        RoutingRoute(
            navigateToHome = {
                backStack.clear()
                backStack.add(HomeDestination.Home)
            },
            navigateToSignUp = {
                backStack.clear()
                backStack.add(SignUpDestination.Welcome)
            },
        )
    }
}