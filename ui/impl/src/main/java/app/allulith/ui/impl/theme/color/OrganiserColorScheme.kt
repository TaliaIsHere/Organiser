package app.allulith.ui.impl.theme.color

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class OrganiserColorScheme(
    val primary: Color,
    val onPrimary: Color,
    val background: Color,
    val onBackground: Color,
    val error: Color,
    val surface: Color,
    val onSurface: Color,
)

internal val LocalOrganiserColors = staticCompositionLocalOf {
    OrganiserColorScheme(
        primary = Color.Unspecified,
        onPrimary = Color.Unspecified,
        background = Color.Unspecified,
        onBackground = Color.Unspecified,
        error = Color.Unspecified,
        surface = Color.Unspecified,
        onSurface = Color.Unspecified,
    )
}
