package app.allulith.goals.impl.destinations.overview.ui

import androidx.compose.runtime.Stable

internal object GoalsOverview {
    data class UiState(
        val tasks: GoalsStructure = GoalsStructure.NoGoals,
    )

    sealed class GoalsStructure {
        data object NoGoals : GoalsStructure()

        @Stable
        data class Goals(val goals: List<Any>) : GoalsStructure()
    }

    sealed class UiEvent {
        data object OnBack : UiEvent()
        data object OnAddGoal : UiEvent()
        data class OnViewGoal(val goal: Any) : UiEvent()
    }
}
