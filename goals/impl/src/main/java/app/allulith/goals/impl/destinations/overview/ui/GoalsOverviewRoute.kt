package app.allulith.goals.impl.destinations.overview.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavKey
import app.allulith.goals.impl.R
import app.allulith.ui.impl.components.appbars.OrganiserTopBar
import app.allulith.ui.impl.components.fab.OrganiserFloatingActionButton
import app.allulith.ui.impl.templates.OrganiserScreen
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
internal fun GoalsOverviewRoute(
    backStack: SnapshotStateList<NavKey>,
    viewModel: GoalsOverviewViewModel = hiltViewModel(
        creationCallback = { factory: GoalsOverviewViewModel.Factory ->
            factory.create(backStack = backStack)
        }
    ),
) {
    OverviewScreen(
        uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
        onUiEvent = viewModel::onUiEvent,
    )
}

@Composable
private fun OverviewScreen(
    uiState: GoalsOverview.UiState,
    onUiEvent: (GoalsOverview.UiEvent) -> Unit,
) {
    OrganiserScreen(
        header = stringResource(R.string.goals_overview_header),
        description = stringResource(R.string.goals_overview_description),
        topBarContent = {
            OrganiserTopBar(
                onBack = {
                    onUiEvent(GoalsOverview.UiEvent.OnBack)
                },
            )
        },
        floatingActionButtonContent = {
            OrganiserFloatingActionButton(
                onClick = {
                    onUiEvent(GoalsOverview.UiEvent.OnAddGoal)
                },
                toolTip = stringResource(R.string.goals_overview_add_goal_tooltip),
                icon = R.drawable.ic_add,
                iconDescription = stringResource(R.string.goals_overview_add_goal_content_description),
            )
        },
    ) {

    }
}

@PreviewLightDark
@Composable
private fun OverviewScreenPreview() {
    OrganiserTheme {
        OverviewScreen(
            uiState = GoalsOverview.UiState(),
            onUiEvent = {},
        )
    }
}
