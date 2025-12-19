package app.allulith.ui.impl.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
fun OrganiserSubHeaderText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
        style = OrganiserTextDefaults.SubHeader.textStyle,
        color = OrganiserTextDefaults.SubHeader.color,
    )
}

@PreviewLightDark
@Composable
private fun OrganiserSubHeaderTextPreview() {
    OrganiserTheme {
        OrganiserHeaderText(
            text = "Header",
        )
    }
}
