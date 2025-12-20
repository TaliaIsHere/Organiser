package app.allulith.tasks.impl.destinations.taskCreation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.allulith.tasks.impl.destinations.overview.ui.Overview
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class TaskCreationViewModel @Inject constructor() : ViewModel() {

    private val eventsChannel: Channel<TaskCreation.Event> = Channel(BUFFERED)
    val eventsFlow = eventsChannel.receiveAsFlow()

    private val _uiState: MutableStateFlow<TaskCreation.UiState> = MutableStateFlow(TaskCreation.UiState())
    val uiState = _uiState.asStateFlow()

    fun onUiEvent(uiEvent: TaskCreation.UiEvent) {
        when (uiEvent) {
            TaskCreation.UiEvent.OnBackTap -> goBack()
            TaskCreation.UiEvent.OnCreateTaskTap -> createTask()
            is TaskCreation.UiEvent.OnDescriptionChange -> onDescriptionChange(text = uiEvent.text)
            is TaskCreation.UiEvent.OnTitleChange -> onTitleChange(text = uiEvent.text)
        }
    }

    private fun goBack() {
        viewModelScope.launch {
            eventsChannel.send(TaskCreation.Event.GoBack)
        }
    }

    private fun createTask() {
        if (_uiState.value.taskTitle.isBlank()) {
            _uiState.update {
                it.copy(taskTitleError = true)
            }
        } else {
            viewModelScope.launch {
                eventsChannel.send(TaskCreation.Event.GoBack)
            }
        }
    }

    private fun onDescriptionChange(text: String) {
        _uiState.update {
            it.copy(taskDescription = text)
        }
    }

    private fun onTitleChange(text: String) {
        _uiState.update {
            it.copy(
                taskTitle = text,
                taskTitleError = false,
            )
        }
    }
}
