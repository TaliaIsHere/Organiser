package app.allulith.ui.impl.templates

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import app.allulith.ui.impl.text.OrganiserBodyText
import app.allulith.ui.impl.text.OrganiserHeaderText
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
fun OrganiserScreen(
    modifier: Modifier = Modifier,
    header: String,
    description: String? = null,
    content: @Composable () -> Unit,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = OrganiserScreenDefaults.containerColor,
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            OrganiserHeaderText(text = header)
            if (description != null) {
                OrganiserBodyText(text = description)
            }
            content()
        }
    }
}

@PreviewLightDark
@Composable
private fun OrganiserScreenPreview() {
    OrganiserTheme {
        OrganiserScreen(
            header = "Header",
            description = "This is a description",
            content = {},
        )
    }
}
