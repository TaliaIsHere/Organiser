package app.allulith.routing.impl.ui

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.allulith.routing.impl.domain.RoutingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@Stable
@HiltViewModel
class RoutingViewModel @Inject constructor(
    routingRepository: RoutingRepository,
) : ViewModel() {
    private val eventsChannel: Channel<Routing.Event> = Channel(BUFFERED)
    val eventsFlow = eventsChannel.receiveAsFlow()

    init {
        viewModelScope.launch {
            val user = routingRepository.getUser()

            when (user == null) {
                true -> eventsChannel.send(Routing.Event.NavigateToSignUp)
                false -> eventsChannel.send(Routing.Event.NavigateToHome)
            }
        }
    }
}
