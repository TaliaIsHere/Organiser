package app.allulith.signup.impl

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import app.allulith.signup.impl.destinations.SignUpDestination
import app.allulith.signup.impl.destinations.accountCreation.AccountCreationRoute
import app.allulith.signup.impl.destinations.welcome.WelcomeRoute
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
fun SignUpNavigation(
    navigateToHome: () -> Unit,
) {
    val backStack = remember { mutableStateListOf<SignUpDestination>() }
    backStack.add(SignUpDestination.Welcome)


    NavDisplay(
        backStack = backStack,
        modifier = Modifier.background(color = OrganiserTheme.colors.background),
        onBack = { backStack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = { key ->
            when (key) {
                SignUpDestination.Welcome -> NavEntry(key) {
                    WelcomeRoute(
                        onContinue = {
                            backStack.add(SignUpDestination.AccountCreation)
                        },
                    )
                }

                SignUpDestination.AccountCreation -> NavEntry(key) {
                    AccountCreationRoute(
                        navigateToHome = navigateToHome,
                    )
                }
            }
        },
        transitionSpec = {
            slideInHorizontally(initialOffsetX = { it }) togetherWith
                slideOutHorizontally(targetOffsetX = { -it })
        },
        popTransitionSpec = {
            slideInHorizontally(initialOffsetX = { -it }) togetherWith
                slideOutHorizontally(targetOffsetX = { it })
        },
        predictivePopTransitionSpec = {
            slideInHorizontally(initialOffsetX = { -it }) togetherWith
                slideOutHorizontally(targetOffsetX = { it })
        },
    )
}
