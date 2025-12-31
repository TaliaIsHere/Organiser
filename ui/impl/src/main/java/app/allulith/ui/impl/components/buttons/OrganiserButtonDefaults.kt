package app.allulith.ui.impl.components.buttons

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import app.allulith.ui.impl.theme.OrganiserTheme

internal object OrganiserButtonDefaults {
    val colors: ButtonColors
        @Composable
        get() = ButtonDefaults.buttonColors(
            containerColor = OrganiserTheme.colors.primary,
            contentColor = OrganiserTheme.colors.onPrimary,
        )

    val textStyle: TextStyle
        @Composable
        get() = OrganiserTheme.typography.body

    val height: Dp
        @Composable
        get() = OrganiserTheme.dimensions.dim700

    val shape: RoundedCornerShape
        @Composable
        get() = RoundedCornerShape(OrganiserTheme.dimensions.dim200)
}
