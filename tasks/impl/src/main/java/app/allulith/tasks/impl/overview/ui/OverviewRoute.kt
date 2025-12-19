package app.allulith.tasks.impl.overview.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.tasks.impl.R
import app.allulith.ui.impl.components.appbars.OrganiserTopBar
import app.allulith.ui.impl.components.fab.OrganiserFloatingActionButton
import app.allulith.ui.impl.templates.OrganiserScreen
import app.allulith.ui.impl.text.OrganiserBodyText
import app.allulith.ui.impl.text.OrganiserSubHeaderText
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
internal fun OverviewRoute() {
    OverviewScreen(
        uiState = Overview.UiState(),
        onUiEvent = {},
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
