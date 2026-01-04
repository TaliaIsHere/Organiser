package app.allulith.ui.impl.components.pickers

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerColors
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.runtime.Composable
import app.allulith.ui.impl.theme.OrganiserTheme

internal object OrganiserTimePickerDefaults {
    
    @OptIn(ExperimentalMaterial3Api::class)
    val colors: TimePickerColors
        @Composable
        get() = TimePickerDefaults.colors(
            clockDialColor = OrganiserTheme.colors.surfaceVariant,
            clockDialSelectedContentColor = OrganiserTheme.colors.onPrimary,
            clockDialUnselectedContentColor = OrganiserTheme.colors.onSurfaceVariant,
            selectorColor = OrganiserTheme.colors.primary,
            containerColor = OrganiserTheme.colors.onSurfaceVariant,
            periodSelectorBorderColor = OrganiserTheme.colors.onSurfaceVariant,
            periodSelectorSelectedContainerColor = OrganiserTheme.colors.primary,
            periodSelectorUnselectedContainerColor = OrganiserTheme.colors.surfaceVariant,
            periodSelectorSelectedContentColor = OrganiserTheme.colors.onPrimary,
            periodSelectorUnselectedContentColor = OrganiserTheme.colors.onSurfaceVariant,
            timeSelectorSelectedContainerColor = OrganiserTheme.colors.primary,
            timeSelectorUnselectedContainerColor = OrganiserTheme.colors.surfaceVariant,
            timeSelectorSelectedContentColor = OrganiserTheme.colors.onPrimary,
            timeSelectorUnselectedContentColor = OrganiserTheme.colors.onSurfaceVariant,
        )
}
