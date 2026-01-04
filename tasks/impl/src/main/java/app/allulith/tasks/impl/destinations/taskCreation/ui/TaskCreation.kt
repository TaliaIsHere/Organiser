package app.allulith.tasks.impl.destinations.taskCreation.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState

internal object TaskCreation {

    data class UiState(
        val taskTitle: String,
        val taskDescription: String,
        val hour: Int? = null,
        val minute: Int? = null,
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
        data class OnTimeChange(
            val hour: Int,
            val minute: Int,
        ) : UiEvent()
        data object OnDismissTimePickerDialog : UiEvent()
        data object OnCreateTaskTap : UiEvent()
        data object OnUpdateTaskTap : UiEvent()
        data object OnBackTap : UiEvent()
        data object OnDeleteTap : UiEvent()
    }
}
