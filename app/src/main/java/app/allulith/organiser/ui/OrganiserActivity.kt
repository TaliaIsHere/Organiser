package app.allulith.organiser.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import app.allulith.ui.impl.theme.OrganiserTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
internal class OrganiserActivity : ComponentActivity() {

    @Inject
    lateinit var entryBuilders: Set<@JvmSuppressWildcards EntryProviderScope<NavKey>.(SnapshotStateList<NavKey>) -> Unit>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val organiserViewModel = hiltViewModel<OrganiserViewModel>()
            val backStack = organiserViewModel.backStack

            OrganiserTheme {
                NavDisplay(
                    backStack = backStack,
                    modifier = Modifier.background(color = OrganiserTheme.colors.background),
                    onBack = { backStack.removeLastOrNull() },
                    entryDecorators = listOf(
                        rememberSaveableStateHolderNavEntryDecorator(),
                        rememberViewModelStoreNavEntryDecorator()
                    ),
                    entryProvider = entryProvider {
                        entryBuilders.forEach { builderFactory ->
                            builderFactory(backStack)
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
        }
    }
}
