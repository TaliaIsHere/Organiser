package app.allulith.ui.impl.templates

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.ui.impl.components.buttons.OrganiserButton
import app.allulith.ui.impl.text.OrganiserBodyText
import app.allulith.ui.impl.text.OrganiserHeaderText
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
fun OrganiserScreen(
    modifier: Modifier = Modifier,
    header: String,
    description: String? = null,
    primaryAction: OrganiserScreenAction? = null,
    content: @Composable () -> Unit,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = OrganiserScreenDefaults.containerColor,
        bottomBar = {
            if (primaryAction != null) {
                Column(
                    modifier = Modifier.padding(
                        start = OrganiserTheme.dimensions.padding.medium,
                        end = OrganiserTheme.dimensions.padding.medium,
                        bottom = WindowInsets.navigationBars.asPaddingValues()
                            .calculateBottomPadding() + OrganiserTheme.dimensions.padding.small,
                    )
                ) {
                    OrganiserButton(
                        text = primaryAction.text,
                        onClick = primaryAction.onClick,
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(OrganiserTheme.dimensions.padding.large)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement
                .spacedBy(OrganiserTheme.dimensions.padding.medium),
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
