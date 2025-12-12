package app.allulith.routing.impl.ui

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.home.api.destinations.home.ui.HomeDestination
import app.allulith.navigation.api.Navigator
import app.allulith.routing.api.ui.RoutingDestination
import app.allulith.routing.impl.routing.ui.RoutingRoute
import app.allulith.signup.impl.destinations.SignUpDestination

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