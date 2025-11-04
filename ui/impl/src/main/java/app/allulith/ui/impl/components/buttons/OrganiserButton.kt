package app.allulith.ui.impl.components.buttons

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
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
        ButtonText(
            text = text,
        )
    }
}

@Composable
private fun ButtonText(text: String) {
    Text(
        text = text,
        style = OrganiserButtonDefaults.textStyle,
    )
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
