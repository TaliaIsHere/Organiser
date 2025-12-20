package app.allulith.tasks.impl.destinations.overview.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.allulith.data.impl.OrganiserDatabase
import app.allulith.tasks.api.domain.Task
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
internal class OverviewViewModel @Inject constructor(
    private val database: OrganiserDatabase,
) : ViewModel() {

    private val eventsChannel: Channel<Overview.Event> = Channel(BUFFERED)
    val eventsFlow = eventsChannel.receiveAsFlow()

    private val _uiState: MutableStateFlow<Overview.UiState> = MutableStateFlow(Overview.UiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            observeTasks()
        }
    }

    private suspend fun observeTasks() {
        database.taskDao().getAll().collect { existingTasks ->
            if (existingTasks.isNotEmpty()) {
                _uiState.update {
                    it.copy(
                        tasks = Overview.TasksStructure.Tasks(
                            tasks = existingTasks.map { existingTask ->
                                Task(
                                    id = existingTask.uid,
                                    title = existingTask.title,
                                    description = existingTask.description,
                                )
                            }
                        )
                    )
                }
            } else {
                _uiState.update {
                    it.copy(tasks = Overview.TasksStructure.NoTasks)
                }
            }
        }
    }

    fun onUiEvent(uiEvent: Overview.UiEvent) {
        when (uiEvent) {
            Overview.UiEvent.OnAddTask -> addTask()
            Overview.UiEvent.OnBack -> onBack()
            is Overview.UiEvent.OnViewTask -> viewTask(task = uiEvent.task)
        }
    }

    private fun addTask() {
        viewModelScope.launch {
            eventsChannel.send(Overview.Event.NavigateToTaskCreation(task = null))
        }
    }

    private fun onBack() {
        viewModelScope.launch {
            eventsChannel.send(Overview.Event.GoBack)
        }
    }

    private fun viewTask(task: Task) {
        viewModelScope.launch {
            eventsChannel.send(Overview.Event.NavigateToTaskCreation(task = task))
        }
    }
}
