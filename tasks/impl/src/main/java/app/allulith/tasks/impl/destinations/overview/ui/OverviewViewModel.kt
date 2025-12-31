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
@HiltViewModel(assistedFactory = OverviewViewModel.Factory::class)
internal class OverviewViewModel @AssistedInject constructor(
    @Assisted private val backStack: SnapshotStateList<NavKey>,
    private val database: OrganiserDatabase,
) : ViewModel() {

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
        fun create(backStack: SnapshotStateList<NavKey>): OverviewViewModel
    }
}
