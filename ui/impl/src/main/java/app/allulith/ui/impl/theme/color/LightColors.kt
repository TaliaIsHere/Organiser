package app.allulith.ui.impl.theme.color

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

internal val lightColors = OrganiserColorScheme(
    primary = Color(0xFF88F1B0),
    onPrimary = Color(0xFF040308),
    background = Color(0xFFF2EFE9),
    onBackground = Color(0xFF040308),
    error = Color(0xFFE5183E),
    surface = Color(0xFFE1DDD8),
    onSurface = Color(0xFF040308),
    surfaceVariant = Color(0xFFD5CFC9),
    onSurfaceVariant = Color(0xFF040308),
)

internal val materialLightColors = lightColorScheme(
    onSurface = Color(0xFF040308),
)
