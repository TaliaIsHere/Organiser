package app.allulith.tasks.impl.destinations.taskDetail.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
internal fun TaskDetailRoute() {
    TaskDetailScreen()
}

@Composable
private fun TaskDetailScreen() {

}

@PreviewLightDark
@Composable
private fun TaskDetailScreenPreview() {
    OrganiserTheme {
        TaskDetailScreen()
    }
}
