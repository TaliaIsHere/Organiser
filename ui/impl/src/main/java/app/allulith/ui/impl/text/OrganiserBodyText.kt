package app.allulith.ui.impl.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
fun OrganiserBodyText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
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
