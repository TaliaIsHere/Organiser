package app.allulith.routing.api.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import app.allulith.navigation.api.Destination

@Composable
fun RoutingRoute(
    backStack: SnapshotStateList<Destination>,
    viewModel: RoutingViewModel = hiltViewModel(),
) {
    LaunchedEffect(Unit) {
        viewModel.eventsFlow.collect { event ->
            when (event) {
                Routing.Event.NavigateToHome -> {
                    backStack.removeLastOrNull()
                    backStack.add(Destination.Home)
                }
                Routing.Event.NavigateToSignUp -> {
                    backStack.removeLastOrNull()
                    backStack.add(Destination.SignUp)
                }
            }
        }
    }
}
