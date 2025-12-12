package app.allulith.signup.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.home.api.destinations.home.ui.HomeDestination
import app.allulith.navigation.api.Navigator
import app.allulith.signup.impl.destinations.SignUpDestination
import app.allulith.signup.impl.destinations.accountCreation.ui.AccountCreationRoute
import app.allulith.signup.impl.destinations.welcome.ui.WelcomeRoute

internal fun EntryProviderScope<NavKey>.signUpNavigation(
    navigator: Navigator,
) {
    entry<SignUpDestination.Welcome> {
        WelcomeRoute(
            onContinue = {
                navigator.addScreen(SignUpDestination.AccountCreation)
            },
        )
    }

    entry<SignUpDestination.AccountCreation> {
        AccountCreationRoute(
            navigateToHome = {
                navigator.addScreen(HomeDestination.Home)
            },
        )
    }
}
