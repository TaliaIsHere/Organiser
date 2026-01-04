package app.allulith.tasks.impl.destinations.overview.ui

import androidx.compose.runtime.Stable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation3.runtime.NavKey
import app.allulith.data.impl.OrganiserDatabase
import app.allulith.tasks.api.destinations.TasksDestination
import app.allulith.tasks.api.domain.Task
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@Stable
@HiltViewModel(assistedFactory = TasksOverviewViewModel.Factory::class)
internal class TasksOverviewViewModel @AssistedInject constructor(
    @Assisted private val backStack: SnapshotStateList<NavKey>,
    private val database: OrganiserDatabase,
) : ViewModel() {

    private val _uiState: MutableStateFlow<TasksOverview.UiState> = MutableStateFlow(TasksOverview.UiState())
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
                        tasks = TasksOverview.TasksStructure.Tasks(
                            tasks = existingTasks.map { existingTask ->
                                Task(
                                    id = existingTask.uid,
                                    title = existingTask.title,
                                    description = existingTask.description,
                                    hour = existingTask.hour,
                                    minute = existingTask.minute,
                                )
                            }
                        )
                    )
                }
            } else {
                _uiState.update {
                    it.copy(tasks = TasksOverview.TasksStructure.NoTasks)
                }
            }
        }
    }

    fun onUiEvent(uiEvent: TasksOverview.UiEvent) {
        when (uiEvent) {
            TasksOverview.UiEvent.OnAddTask -> addTask()
            TasksOverview.UiEvent.OnBack -> onBack()
            is TasksOverview.UiEvent.OnViewTask -> viewTask(task = uiEvent.task)
        }
    }

    private fun addTask() {
        backStack.add(TasksDestination.TaskCreation(task = null))
    }

    private fun onBack() {
        backStack.removeLastOrNull()
    }

    private fun viewTask(task: Task) {
        backStack.add(TasksDestination.TaskCreation(task = task))
    }

    @AssistedFactory
    interface Factory {
        fun create(backStack: SnapshotStateList<NavKey>): TasksOverviewViewModel
    }
}
