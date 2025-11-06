package app.allulith.organiser.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import app.allulith.ui.impl.theme.OrganiserTheme

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
internal fun OrganiserLoadingScreen() {
    Scaffold(
        containerColor = OrganiserTheme.colors.background,
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
        ) {
            LoadingIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(128.dp),
                color = OrganiserTheme.colors.primary,
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun OrganiserLoadingScreenPreview() {
    OrganiserTheme {
        OrganiserLoadingScreen()
    }
}
