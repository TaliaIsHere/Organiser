package app.allulith.organiser.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import app.allulith.navigation.api.Destination
import app.allulith.routing.api.ui.RoutingRoute
import app.allulith.signup.impl.ui.SignUpRoute
import app.allulith.ui.impl.templates.OrganiserScreen
import app.allulith.ui.impl.theme.OrganiserTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class OrganiserActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val backStack = remember { mutableStateListOf<Destination>() }
            backStack.add(Destination.Routing)

            OrganiserTheme {
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
                            Destination.Routing -> NavEntry(key) {
                                RoutingRoute(backStack = backStack)
                            }
                            Destination.SignUp -> NavEntry(key) {
                                SignUpRoute(
                                    onContinue = {
                                        backStack.add(Destination.Home)
                                    },
                                )
                            }
                            Destination.Home -> NavEntry(key) {
                                OrganiserScreen(
                                    header = "Home"
                                ) {}
                            }
                        }
                    }
                )
            }
        }
    }
}
