package app.allulith.ui.impl.components.switch

import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import app.allulith.ui.impl.theme.OrganiserTheme

internal object OrganiserSwitchDefaults {
    val colors: SwitchColors
        @Composable
        get() = SwitchDefaults.colors(
            checkedThumbColor = OrganiserTheme.colors.surface,
            checkedTrackColor = OrganiserTheme.colors.primary,
            checkedBorderColor = OrganiserTheme.colors.primary,
            checkedIconColor = OrganiserTheme.colors.onSurface,
            uncheckedThumbColor = OrganiserTheme.colors.onSurface,
            uncheckedTrackColor = OrganiserTheme.colors.surface,
            uncheckedBorderColor = OrganiserTheme.colors.onSurface,
            uncheckedIconColor = OrganiserTheme.colors.surface,
            disabledCheckedThumbColor = OrganiserTheme.colors.surface.copy(alpha = 0.5f),
            disabledCheckedTrackColor = OrganiserTheme.colors.primary.copy(alpha = 0.5f),
            disabledCheckedBorderColor = OrganiserTheme.colors.primary.copy(alpha = 0.5f),
            disabledCheckedIconColor = OrganiserTheme.colors.onSurface.copy(alpha = 0.5f),
            disabledUncheckedThumbColor = OrganiserTheme.colors.onSurface.copy(alpha = 0.5f),
            disabledUncheckedTrackColor = OrganiserTheme.colors.surface.copy(alpha = 0.5f),
            disabledUncheckedBorderColor = OrganiserTheme.colors.onSurface.copy(alpha = 0.5f),
            disabledUncheckedIconColor = OrganiserTheme.colors.surface.copy(alpha = 0.5f),
        )
}
