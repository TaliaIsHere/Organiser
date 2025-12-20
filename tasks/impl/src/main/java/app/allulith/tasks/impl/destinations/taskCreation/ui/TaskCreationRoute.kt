package app.allulith.tasks.impl.destinations.taskCreation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.ui.impl.components.appbars.OrganiserTopBar
import app.allulith.ui.impl.templates.OrganiserScreen

@Composable
fun TaskCreationRoute() {
    TaskCreationScreen()
}

@Composable
private fun TaskCreationScreen() {
    OrganiserScreen(
        header = "Create a task",
        description = "TODO",
        topBarContent = {
            OrganiserTopBar(
                onBack = {},
            )
        },
    ) {

    }
}

@PreviewLightDark
@Composable
private fun TaskCreationScreenPreview() {

}
