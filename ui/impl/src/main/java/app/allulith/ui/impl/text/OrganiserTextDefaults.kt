package app.allulith.ui.impl.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import app.allulith.ui.impl.theme.OrganiserTheme

internal object OrganiserTextDefaults {
    object Header {
        val color: Color
            @Composable
            get() = OrganiserTheme.colors.onBackground

        val textStyle: TextStyle
            @Composable
            get() = OrganiserTheme.typography.header
    }

    object Body {
        val color: Color
            @Composable
            get() = OrganiserTheme.colors.onBackground

        val textStyle: TextStyle
            @Composable
            get() = OrganiserTheme.typography.body
    }
}
