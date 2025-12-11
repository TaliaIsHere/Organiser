package app.allulith.settings.impl

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
import app.allulith.settings.impl.destinations.settings.ui.SettingsDestination
import app.allulith.settings.impl.destinations.settings.ui.SettingsRoute
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
fun SettingsNavigation(
    onBack: () -> Unit,
) {
    val backStack = remember { mutableStateListOf<SettingsDestination>(SettingsDestination.Settings) }

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
                SettingsDestination.Settings -> NavEntry(key) {
                    SettingsRoute(
                        onBack = onBack,
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
