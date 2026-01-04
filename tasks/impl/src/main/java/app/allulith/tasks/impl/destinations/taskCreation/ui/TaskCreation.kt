package app.allulith.tasks.impl.destinations.taskCreation.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState

internal object TaskCreation {

    data class UiState(
        val taskTitle: String,
        val taskDescription: String,
        // TODO extract this compose class out of the state and simplify to hour and minute fields instead
        @OptIn(ExperimentalMaterial3Api::class)
        val timePickerState: TimePickerState? = null,
        val isTimePickerVisible: Boolean = false,
        val taskTitleError: Boolean = false,
        val timeError: Boolean = false,
        val taskState: TaskState,
    )

    sealed class TaskState {
        data object Edit : TaskState()
        data object New : TaskState()
    }

    sealed class UiEvent {
        data class OnTitleChange(val text: String) : UiEvent()
        data class OnDescriptionChange(val text: String) : UiEvent()
        data object OnShowTimerPicker : UiEvent()
        @OptIn(ExperimentalMaterial3Api::class)
        data class OnTimeChange(val timePickerState: TimePickerState) : UiEvent()
        data object OnDismissTimePickerDialog : UiEvent()
        data object OnCreateTaskTap : UiEvent()
        data object OnUpdateTaskTap : UiEvent()
        data object OnBackTap : UiEvent()
        data object OnDeleteTap : UiEvent()
    }
}
