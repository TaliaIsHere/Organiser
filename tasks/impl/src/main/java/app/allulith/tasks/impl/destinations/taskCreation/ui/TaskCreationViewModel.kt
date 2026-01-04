package app.allulith.tasks.impl.destinations.taskCreation.ui

import android.content.Context
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Stable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation3.runtime.NavKey
import app.allulith.data.impl.OrganiserDatabase
import app.allulith.data.impl.entity.Task
import app.allulith.notification.api.domain.NotificationRepository
import app.allulith.notification.api.domain.Reminder
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid
import app.allulith.tasks.api.domain.Task as DomainTask

@Stable
@OptIn(ExperimentalMaterial3Api::class)
@HiltViewModel(assistedFactory = TaskCreationViewModel.Factory::class)
internal class TaskCreationViewModel @AssistedInject constructor(
    @param:ApplicationContext val context: Context,
    @Assisted private val backStack: SnapshotStateList<NavKey>,
    @Assisted private val task: DomainTask?,
    private val database: OrganiserDatabase,
    private val notificationRepository: NotificationRepository,
) : ViewModel() {

    private val _uiState: MutableStateFlow<TaskCreation.UiState> = MutableStateFlow(
        TaskCreation.UiState(
            taskTitle = task?.title ?: "",
            taskDescription = task?.description ?: "",
            hour = task?.hour,
            minute = task?.minute,
            taskState = if (task == null) {
                TaskCreation.TaskState.New
            } else {
                TaskCreation.TaskState.Edit
            },
        )
    )
    val uiState = _uiState.asStateFlow()

    @OptIn(ExperimentalMaterial3Api::class)
    fun onUiEvent(uiEvent: TaskCreation.UiEvent) {
        when (uiEvent) {
            TaskCreation.UiEvent.OnBackTap -> goBack()
            TaskCreation.UiEvent.OnCreateTaskTap -> createTask()
            is TaskCreation.UiEvent.OnDescriptionChange -> onDescriptionChange(text = uiEvent.text)
            is TaskCreation.UiEvent.OnTitleChange -> onTitleChange(text = uiEvent.text)
            TaskCreation.UiEvent.OnShowTimerPicker -> showTimePicker()
            TaskCreation.UiEvent.OnDismissTimePickerDialog -> hideTimePicker()
            is TaskCreation.UiEvent.OnTimeChange -> {
                onTimeChange(
                    hour = uiEvent.hour,
                    minute = uiEvent.minute,
                )
            }
            TaskCreation.UiEvent.OnDeleteTap -> deleteTask()
            TaskCreation.UiEvent.OnUpdateTaskTap -> updateTask()
        }
    }

    private fun goBack() {
        backStack.removeLastOrNull()
    }

    @OptIn(ExperimentalUuidApi::class)
    private fun createTask() {
        val uiState = _uiState.value

        if (uiState.taskTitle.isBlank() || uiState.hour == null || uiState.minute == null) {
            _uiState.update {
                it.copy(
                    taskTitleError = uiState.taskTitle.isBlank(),
                    timeError = uiState.hour == null || uiState.minute == null,
                )
            }
        } else {
            viewModelScope.launch {
                val task = Task(
                    uid = Uuid.random().toString(),
                    title = uiState.taskTitle,
                    description = uiState.taskDescription.ifEmpty { null },
                    hour = uiState.hour,
                    minute = uiState.minute,
                )

                database.taskDao().insertAll(task)
                setReminder(task = task)
                goBack()
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

    private fun showTimePicker() {
        _uiState.update {
            it.copy(
                isTimePickerVisible = true,
            )
        }
    }

    private fun hideTimePicker() {
        _uiState.update {
            it.copy(
                isTimePickerVisible = false,
            )
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    private fun onTimeChange(
        hour: Int,
        minute: Int,
    ) {
        _uiState.update {
            it.copy(
                hour = hour,
                minute = minute,
                isTimePickerVisible = false,
            )
        }
    }

    private fun deleteTask() {
        viewModelScope.launch {
            if (task != null) {
                database.taskDao().delete(uid = task.id)
                goBack()
            }
        }
    }

    // TODO unify with add task function almost identical
    private fun updateTask() {
        val uiState = _uiState.value

        if (task != null) {
            if (uiState.taskTitle.isBlank() || uiState.hour == null || uiState.minute == null) {
                _uiState.update {
                    it.copy(
                        taskTitleError = uiState.taskTitle.isBlank(),
                        timeError = uiState.hour == null || uiState.minute == null,
                    )
                }
            } else {
                viewModelScope.launch {
                    val task = Task(
                        uid = task.id,
                        title = uiState.taskTitle,
                        description = uiState.taskDescription.ifEmpty { null },
                        hour = uiState.hour,
                        minute = uiState.minute,
                    )

                    database.taskDao().update(task)
                    notificationRepository.cancelReminder(
                        context = context,
                        reminderId = task.uidToInt(),
                    )
                    setReminder(task = task)
                    goBack()
                }
            }
        }
    }

    private fun setReminder(task: Task) {
        notificationRepository.scheduleExactReminder(
            context = context,
            reminder = Reminder(
                id = task.uidToInt(),
                hour = task.hour,
                minute = task.minute,
                title = task.title,
                message = task.description,
            )
        )
    }

    @AssistedFactory
    interface Factory {
        fun create(
            backStack: SnapshotStateList<NavKey>,
            task: DomainTask?,
        ): TaskCreationViewModel
    }
}
