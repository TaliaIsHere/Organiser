package app.allulith.routing.impl.destinations.routing.ui

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.allulith.routing.impl.destinations.routing.domain.RoutingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@Stable
@HiltViewModel
internal class RoutingViewModel @Inject constructor(
    routingRepository: RoutingRepository,
) : ViewModel() {
    private val eventsChannel: Channel<Routing.Event> = Channel(Channel.BUFFERED)
    val eventsFlow = eventsChannel.receiveAsFlow()

    init {
        viewModelScope.launch {
            routingRepository.getUser().fold(
                ifRight = { eventsChannel.send(Routing.Event.NavigateToHome) },
                ifLeft = { eventsChannel.send(Routing.Event.NavigateToSignUp) },
            )
        }
    }
}
