package app.allulith.ui.impl.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
fun OrganiserBodyText(
    text: String,
) {
    Text(
        text = text,
        style = OrganiserTextDefaults.Body.textStyle,
        color = OrganiserTextDefaults.Body.color,
    )
}

@PreviewLightDark
@Composable
private fun OrganiserBodyTextPreview() {
    OrganiserTheme {
        OrganiserBodyText(
            text = "Example",
        )
    }
}
