package app.allulith.goals.impl.destinations.overview.ui

import androidx.compose.runtime.Stable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.navigation3.runtime.NavKey
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@Stable
@HiltViewModel(assistedFactory = GoalsOverviewViewModel.Factory::class)
internal class GoalsOverviewViewModel @AssistedInject constructor(
    @Assisted private val backStack: SnapshotStateList<NavKey>,
) : ViewModel() {

    private val _uiState: MutableStateFlow<GoalsOverview.UiState> = MutableStateFlow(GoalsOverview.UiState())
    val uiState = _uiState.asStateFlow()

    fun onUiEvent(uiEvent: GoalsOverview.UiEvent) {
        when (uiEvent) {
            GoalsOverview.UiEvent.OnAddGoal -> addTask()
            GoalsOverview.UiEvent.OnBack -> onBack()
            is GoalsOverview.UiEvent.OnViewGoal -> viewTask()
        }
    }

    private fun addTask() {
        TODO()
    }

    private fun onBack() {
        backStack.removeLastOrNull()
    }

    private fun viewTask() {
        TODO()
    }

    @AssistedFactory
    interface Factory {
        fun create(backStack: SnapshotStateList<NavKey>): GoalsOverviewViewModel
    }
}
