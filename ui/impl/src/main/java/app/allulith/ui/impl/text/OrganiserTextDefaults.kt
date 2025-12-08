package app.allulith.ui.impl.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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

    object Error {
        val color: Color
            @Composable
            get() = OrganiserTheme.colors.error

        val textStyle: TextStyle
            @Composable
            get() = OrganiserTheme.typography.body.copy(fontWeight = FontWeight.Bold)
    }
}
