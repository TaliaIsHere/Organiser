package app.allulith.routing.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.home.api.destinations.HomeDestination
import app.allulith.navigation.api.Navigator
import app.allulith.routing.api.destinations.RoutingDestination
import app.allulith.routing.impl.destinations.routing.ui.RoutingRoute
import app.allulith.signup.api.destinations.SignUpDestination

internal fun EntryProviderScope<NavKey>.routingNavigationBuilder(
    navigator: Navigator,
) {
    entry<RoutingDestination.Routing> {
        RoutingRoute(
            navigateToHome = {
                navigator.addScreen(HomeDestination.Home)
            },
            navigateToSignUp = {
                navigator.addScreen(SignUpDestination.Welcome)
            },
        )
    }
}