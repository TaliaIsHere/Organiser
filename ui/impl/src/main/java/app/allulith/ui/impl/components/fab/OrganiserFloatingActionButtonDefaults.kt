package app.allulith.ui.impl.components.fab

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import app.allulith.ui.impl.theme.OrganiserTheme

internal object OrganiserFloatingActionButtonDefaults {
    val containerColor: Color
        @Composable
        get() = OrganiserTheme.colors.primary

    val contentColor: Color
        @Composable
        get() = OrganiserTheme.colors.onPrimary
}
