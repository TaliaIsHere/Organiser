package app.allulith.ui.impl.components.buttons

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
fun OrganiserButton(
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = OrganiserButtonDefaults.colors,
    ) {
        Text(
            text = "Click me!",
            style = OrganiserButtonDefaults.type,
        )
    }
}

@PreviewLightDark
@Composable
private fun OrganiserButtonPreview() {
    OrganiserTheme {
        OrganiserButton(
            onClick = {},
        )
    }
}
