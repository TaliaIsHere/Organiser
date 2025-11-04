package app.allulith.ui.impl.components.buttons

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import app.allulith.ui.impl.theme.OrganiserTheme

internal object OrganiserButtonDefaults {
    val colors: ButtonColors
        @Composable
        get() = ButtonDefaults.buttonColors(
            containerColor = OrganiserTheme.colors.background,
        )

    val type: TextStyle
        @Composable
        get() = OrganiserTheme.typography.body
}
