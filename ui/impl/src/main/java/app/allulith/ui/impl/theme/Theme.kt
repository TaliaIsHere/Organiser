package app.allulith.ui.impl.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import app.allulith.ui.impl.theme.color.LocalOrganiserColors
import app.allulith.ui.impl.theme.color.OrganiserColorScheme
import app.allulith.ui.impl.theme.color.darkColors
import app.allulith.ui.impl.theme.color.lightColors
import app.allulith.ui.impl.theme.type.LocalOrganiserTypography
import app.allulith.ui.impl.theme.type.OrganiserTypography
import app.allulith.ui.impl.theme.type.typography

@Composable
fun OrganiserTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        darkTheme -> darkColors
        else -> lightColors
    }

    CompositionLocalProvider(
        LocalOrganiserColors provides colorScheme,
        LocalOrganiserTypography provides typography,
        content = content,
    )
}

object OrganiserTheme {
    val colors: OrganiserColorScheme
        @Composable
        get() = LocalOrganiserColors.current

    val typography: OrganiserTypography
        @Composable
        get() = LocalOrganiserTypography.current
}
