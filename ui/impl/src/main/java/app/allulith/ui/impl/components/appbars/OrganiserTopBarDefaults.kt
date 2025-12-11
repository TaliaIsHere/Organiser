package app.allulith.ui.impl.components.appbars

import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import app.allulith.ui.impl.theme.OrganiserTheme

internal object OrganiserTopBarDefaults {
    val colors: TopAppBarColors
        @Composable
        get() = TopAppBarDefaults.topAppBarColors(
            containerColor = OrganiserTheme.colors.background,
            scrolledContainerColor = OrganiserTheme.colors.background,
            navigationIconContentColor = OrganiserTheme.colors.onBackground,
            titleContentColor = OrganiserTheme.colors.onBackground,
            actionIconContentColor = OrganiserTheme.colors.onBackground,
            subtitleContentColor = OrganiserTheme.colors.onBackground,
        )
}
