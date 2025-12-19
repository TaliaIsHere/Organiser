package app.allulith.tasks.impl.destinations.overview.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class OverviewViewModel @Inject constructor() : ViewModel() {

    private val eventsChannel: Channel<Overview.Event> = Channel(BUFFERED)
    val eventsFlow = eventsChannel.receiveAsFlow()

    private val _uiState: MutableStateFlow<Overview.UiState> = MutableStateFlow(Overview.UiState())
    val uiState = _uiState.asStateFlow()

    fun onUiEvent(uiEvent: Overview.UiEvent) {
        when (uiEvent) {
            Overview.UiEvent.OnAddTask -> addTask()
            Overview.UiEvent.OnBack -> onBack()
        }
    }

    private fun addTask() {
        viewModelScope.launch {
            eventsChannel.send(Overview.Event.NavigateToTaskCreation)
        }
    }

    private fun onBack() {
        viewModelScope.launch {
            eventsChannel.send(Overview.Event.GoBack)
        }
    }
}
