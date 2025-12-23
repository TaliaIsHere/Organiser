package app.allulith.signup.impl

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.home.api.destinations.HomeDestination
import app.allulith.signup.api.destinations.SignUpDestination
import app.allulith.signup.impl.destinations.accountCreation.ui.AccountCreationRoute
import app.allulith.signup.impl.destinations.welcome.ui.WelcomeRoute

internal fun EntryProviderScope<NavKey>.signUpNavigation(
    backStack: SnapshotStateList<NavKey>,
) {
    entry<SignUpDestination.Welcome> {
        WelcomeRoute(
            onContinue = {
                backStack.add(SignUpDestination.AccountCreation)
            },
        )
    }

    entry<SignUpDestination.AccountCreation> {
        AccountCreationRoute(
            navigateToHome = {
                backStack.clear()
                backStack.add(HomeDestination.Home)
            },
        )
    }
}
