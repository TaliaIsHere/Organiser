package app.allulith.home.impl.destinations.home.ui

import androidx.compose.runtime.Stable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation3.runtime.NavKey
import app.allulith.home.impl.destinations.home.domain.HomeRepository
import app.allulith.settings.api.destinations.SettingsDestination
import app.allulith.tasks.api.destinations.TasksDestination
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
import javax.inject.Inject

@Stable
@HiltViewModel(assistedFactory = HomeViewModel.Factory::class)
internal class HomeViewModel @AssistedInject constructor(
    @Assisted val backStack: SnapshotStateList<NavKey>,
    private val repository: HomeRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(Home.UiState())
    val uiState = _uiState.asStateFlow()

    init {
        personalizeHome()
    }

    private fun personalizeHome() {
        viewModelScope.launch {
            repository.getUserName().onRight { name ->
                _uiState.update { it.copy(name = name) }
            }
        }
    }

    fun onUiEvent(uiEvent: Home.UiEvent) {
        when (uiEvent) {
            Home.UiEvent.OnSettingsTap -> navigateToSettings()
            Home.UiEvent.OnTasksTap -> navigateToTasks()
            Home.UiEvent.OnGoalsTap -> TODO()
            Home.UiEvent.OnRemindersTap -> TODO()
        }
    }

    private fun navigateToSettings() {
        backStack.add(SettingsDestination.Settings)
    }

    private fun navigateToTasks() {
        backStack.add(TasksDestination.Overview)
    }

    @AssistedFactory
    interface Factory {
        fun create(backStack: SnapshotStateList<NavKey>): HomeViewModel
    }
}
