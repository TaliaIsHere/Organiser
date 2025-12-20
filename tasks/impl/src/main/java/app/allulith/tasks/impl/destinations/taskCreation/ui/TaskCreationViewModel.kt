package app.allulith.tasks.impl.destinations.taskCreation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.allulith.data.impl.OrganiserDatabase
import app.allulith.data.impl.entity.Task
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid
import app.allulith.tasks.api.domain.Task as DomainTask

@HiltViewModel(assistedFactory = TaskCreationViewModel.Factory::class)
internal class TaskCreationViewModel @AssistedInject constructor(
    @Assisted val task: DomainTask?,
    private val database: OrganiserDatabase,
) : ViewModel() {

    private val eventsChannel: Channel<TaskCreation.Event> = Channel(BUFFERED)
    val eventsFlow = eventsChannel.receiveAsFlow()

    private val _uiState: MutableStateFlow<TaskCreation.UiState> = MutableStateFlow(
        TaskCreation.UiState(
            taskTitle = task?.title ?: "",
            taskDescription = task?.description ?: "",
            taskState = if (task == null) {
                TaskCreation.TaskState.New
            } else {
                TaskCreation.TaskState.Edit
            }
        )
    )
    val uiState = _uiState.asStateFlow()

    fun onUiEvent(uiEvent: TaskCreation.UiEvent) {
        when (uiEvent) {
            TaskCreation.UiEvent.OnBackTap -> goBack()
            TaskCreation.UiEvent.OnCreateTaskTap -> createTask()
            is TaskCreation.UiEvent.OnDescriptionChange -> onDescriptionChange(text = uiEvent.text)
            is TaskCreation.UiEvent.OnTitleChange -> onTitleChange(text = uiEvent.text)
            TaskCreation.UiEvent.OnDeleteTap -> deleteTask()
            TaskCreation.UiEvent.OnUpdateTaskTap -> updateTask()
        }
    }

    private fun goBack() {
        viewModelScope.launch {
            eventsChannel.send(TaskCreation.Event.GoBack)
        }
    }

    @OptIn(ExperimentalUuidApi::class)
    private fun createTask() {
        val uiState = _uiState.value
        if (uiState.taskTitle.isBlank()) {
            _uiState.update {
                it.copy(taskTitleError = true)
            }
        } else {
            viewModelScope.launch {
                database.taskDao().insertAll(
                    Task(
                        uid = Uuid.random().toString(),
                        title = uiState.taskTitle,
                        description = uiState.taskDescription.ifEmpty { null },
                    )
                )

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

    private fun deleteTask() {
        viewModelScope.launch {
            if (task != null) {
                database.taskDao().delete(uid = task.id)
                eventsChannel.send(TaskCreation.Event.GoBack)
            }
        }
    }

    private fun updateTask() {
        val uiState = _uiState.value
        if (task != null) {
            if (uiState.taskTitle.isBlank()) {
                _uiState.update {
                    it.copy(taskTitleError = true)
                }
            } else {
                viewModelScope.launch {
                    database.taskDao().update(
                        Task(
                            uid = task.id,
                            title = uiState.taskTitle,
                            description = uiState.taskDescription.ifEmpty { null },
                        )
                    )
                    eventsChannel.send(TaskCreation.Event.GoBack)
                }
            }
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(task: DomainTask?): TaskCreationViewModel
    }
}
