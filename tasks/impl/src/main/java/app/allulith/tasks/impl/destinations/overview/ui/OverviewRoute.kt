package app.allulith.tasks.impl.destinations.overview.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.allulith.tasks.impl.R
import app.allulith.ui.impl.components.appbars.OrganiserTopBar
import app.allulith.ui.impl.components.fab.OrganiserFloatingActionButton
import app.allulith.ui.impl.templates.OrganiserScreen
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
internal fun OverviewRoute(
    goBack: () -> Unit,
    navigateToTaskCreation: () -> Unit,
    viewModel: OverviewViewModel = hiltViewModel(),
) {
    LaunchedEffect(Unit) {
        viewModel.eventsFlow.collect { event ->
            when (event) {
                Overview.Event.GoBack -> goBack()
                Overview.Event.NavigateToTaskCreation -> navigateToTaskCreation()
            }
        }
    }

    OverviewScreen(
        uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
        onUiEvent = viewModel::onUiEvent,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OverviewScreen(
    uiState: Overview.UiState,
    onUiEvent: (Overview.UiEvent) -> Unit,
) {
    OrganiserScreen(
        header = stringResource(R.string.overview_header),
        description = stringResource(R.string.overview_description),
        topBarContent = {
            OrganiserTopBar(
                onBack = {
                    onUiEvent(Overview.UiEvent.OnBack)
                },
            )
        },
        floatingActionButtonContent = {
            OrganiserFloatingActionButton(
                onClick = {
                    onUiEvent(Overview.UiEvent.OnAddTask)
                },
                toolTip = stringResource(R.string.overview_add_task_tooltip),
                icon = R.drawable.ic_add,
                iconDescription = stringResource(R.string.overview_add_task_content_description),
            )
        },
    ) {
        when (uiState.tasks) {
            Overview.TasksStructure.NoTasks -> NoTasks()
            is Overview.TasksStructure.Tasks -> Tasks(tasks = uiState.tasks)
        }
    }
}

@Composable
private fun NoTasks() {
    Column {

    }
}

@Composable
private fun Tasks(
    tasks: Overview.TasksStructure.Tasks,
) {
    Column {

    }
}

@PreviewLightDark
@Composable
private fun OverviewScreenPreview() {
    OrganiserTheme {
        OverviewScreen(
            uiState = Overview.UiState(),
            onUiEvent = {},
        )
    }
}
