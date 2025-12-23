package app.allulith.routing.impl.destinations.routing.ui

import androidx.compose.runtime.Stable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation3.runtime.NavKey
import app.allulith.home.api.destinations.HomeDestination
import app.allulith.routing.impl.destinations.routing.domain.RoutingRepository
import app.allulith.signup.api.destinations.SignUpDestination
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@Stable
@HiltViewModel(assistedFactory = RoutingViewModel.Factory::class)
internal class RoutingViewModel @AssistedInject constructor(
    @Assisted private val backStack: SnapshotStateList<NavKey>,
    private val routingRepository: RoutingRepository,
) : ViewModel() {

    fun route() {
        viewModelScope.launch {
            routingRepository.getUser().fold(
                ifRight = { backStack.add(HomeDestination.Home) },
                ifLeft = { backStack.add(SignUpDestination.Welcome) },
            )
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(backStack: SnapshotStateList<NavKey>): RoutingViewModel
    }
}
