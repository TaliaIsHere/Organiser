package app.allulith.tasks.impl.destinations.taskCreation.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.allulith.tasks.api.domain.Task
import app.allulith.tasks.impl.R
import app.allulith.ui.impl.components.appbars.OrganiserTopBar
import app.allulith.ui.impl.components.appbars.OrganiserTopBarAction
import app.allulith.ui.impl.components.textfields.OrganiserTextField
import app.allulith.ui.impl.templates.OrganiserScreen
import app.allulith.ui.impl.templates.OrganiserScreenAction
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
internal fun TaskCreationRoute(
    task: Task?,
    goBack: () -> Unit,
    viewModel: TaskCreationViewModel = hiltViewModel(
        creationCallback = { factory: TaskCreationViewModel.Factory ->
            factory.create(task)
        }
    ),
) {
    LaunchedEffect(Unit) {
        viewModel.eventsFlow.collect { event ->
            when (event) {
                TaskCreation.Event.GoBack -> goBack()
            }
        }
    }

    TaskCreationScreen(
        uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
        onUiEvent = viewModel::onUiEvent,
    )
}

@Composable
private fun TaskCreationScreen(
    uiState: TaskCreation.UiState,
    onUiEvent: (TaskCreation.UiEvent) -> Unit,
) {
    when (uiState.taskState) {
        TaskCreation.TaskState.Edit -> {
            EditSection(
                uiState = uiState,
                onUiEvent = onUiEvent,
            )
        }
        TaskCreation.TaskState.New -> {
            NewSection(
                uiState = uiState,
                onUiEvent = onUiEvent,
            )
        }
    }
}

@Composable
private fun EditSection(
    uiState: TaskCreation.UiState,
    onUiEvent: (TaskCreation.UiEvent) -> Unit,
) {
    OrganiserScreen(
        header = stringResource(R.string.task_creation_edit_header),
        description = stringResource(R.string.task_creation_edit_description),
        primaryAction = OrganiserScreenAction(
            onClick = {
                onUiEvent(TaskCreation.UiEvent.OnUpdateTaskTap)
            },
            text = stringResource(R.string.task_creation_edit_action_text),
        ),
        topBarContent = {
            OrganiserTopBar(
                onBack = {
                    onUiEvent(TaskCreation.UiEvent.OnBackTap)
                },
                actions = listOf(
                    OrganiserTopBarAction(
                        contentDescription = stringResource(R.string.task_creation_delete_content_description),
                        image = R.drawable.ic_delete,
                        onClick = { onUiEvent(TaskCreation.UiEvent.OnDeleteTap) },
                    )
                ),
            )
        },
    ) {
        Content(
            uiState = uiState,
            onUiEvent = onUiEvent,
        )
    }
}

@Composable
private fun NewSection(
    uiState: TaskCreation.UiState,
    onUiEvent: (TaskCreation.UiEvent) -> Unit,
) {
    OrganiserScreen(
        header = stringResource(R.string.task_creation_header),
        description = stringResource(R.string.task_creation_description),
        primaryAction = OrganiserScreenAction(
            onClick = {
                onUiEvent(TaskCreation.UiEvent.OnCreateTaskTap)
            },
            text = stringResource(R.string.task_creation_action_text),
        ),
        topBarContent = {
            OrganiserTopBar(
                onBack = {
                    onUiEvent(TaskCreation.UiEvent.OnBackTap)
                },
            )
        },
    ) {
        Content(
            uiState = uiState,
            onUiEvent = onUiEvent,
        )
    }
}

@Composable
private fun Content(
    uiState: TaskCreation.UiState,
    onUiEvent: (TaskCreation.UiEvent) -> Unit,
) {
    OrganiserTextField(
        text = uiState.taskTitle,
        onValueChange = { text ->
            onUiEvent(TaskCreation.UiEvent.OnTitleChange(text = text))
        },
        modifier = Modifier.fillMaxWidth(),
        label = stringResource(R.string.task_creation_title_text_field_label),
        placeholder = "",
        isError = uiState.taskTitleError,
        errorText = stringResource(R.string.task_creation_title_error_text),
    )
    OrganiserTextField(
        text = uiState.taskDescription,
        onValueChange = { text ->
            onUiEvent(TaskCreation.UiEvent.OnDescriptionChange(text = text))
        },
        modifier = Modifier.fillMaxWidth(),
        label = stringResource(R.string.task_creation_description_text_field_label),
        placeholder = "",
    )
}

@PreviewLightDark
@Composable
private fun TaskCreationScreenPreview() {
    OrganiserTheme {
        TaskCreationScreen(
            uiState = TaskCreation.UiState(
                taskTitle = "",
                taskDescription = "",
                taskState = TaskCreation.TaskState.New,
            ),
            onUiEvent = {},
        )
    }
}
