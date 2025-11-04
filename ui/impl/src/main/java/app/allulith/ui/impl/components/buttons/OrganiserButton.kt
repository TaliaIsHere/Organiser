package app.allulith.ui.impl.components.buttons

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.ui.impl.text.OrganiserBodyText
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
fun OrganiserButton(
    text: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = OrganiserButtonDefaults.colors,
    ) {
        OrganiserBodyText(
            text = text,
        )
    }
}

@PreviewLightDark
@Composable
private fun OrganiserButtonPreview() {
    OrganiserTheme {
        OrganiserButton(
            text = "Click me!",
            onClick = {},
        )
    }
}
