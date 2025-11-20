package app.allulith.ui.impl.theme.color

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class OrganiserColorScheme(
    val onBackground: Color,
    val background: Color,
)

internal val LocalOrganiserColors = staticCompositionLocalOf {
    OrganiserColorScheme(
        onBackground = Color.Unspecified,
        background = Color.Unspecified,
    )
}
