package app.allulith.ui.impl.components.cards

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import app.allulith.ui.impl.theme.OrganiserTheme

internal object OrganiserCardDefaults {
    val colors: CardColors
        @Composable
        get() = CardDefaults.cardColors(
            containerColor = OrganiserTheme.colors.surface,
            contentColor = OrganiserTheme.colors.onSurface,
            disabledContainerColor = OrganiserTheme.colors.surface.copy(alpha = 0.5f),
            disabledContentColor = OrganiserTheme.colors.onSurface.copy(alpha = 0.5f),
        )

    val textStyle: TextStyle
        @Composable
        get() = OrganiserTheme.typography.subHeader

    val shape: RoundedCornerShape
        @Composable
        get() = RoundedCornerShape(OrganiserTheme.dimensions.dim150)
}
