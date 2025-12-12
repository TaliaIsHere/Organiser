package app.allulith.routing.impl.routing.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
internal fun RoutingRoute(
    viewModel: RoutingViewModel = hiltViewModel(),
    navigateToHome: () -> Unit,
    navigateToSignUp: () -> Unit,
) {
    LaunchedEffect(Unit) {
        viewModel.eventsFlow.collect { event ->
            when (event) {
                Routing.Event.NavigateToHome -> navigateToHome()
                Routing.Event.NavigateToSignUp -> navigateToSignUp()
            }
        }
    }
}
