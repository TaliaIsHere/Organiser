package app.allulith.ui.impl.theme.color

import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.graphics.Color

internal val darkColors = OrganiserColorScheme(
    primary = Color(0xFF79C99E),
    onPrimary = Color(0xFF040308),
    background = Color(0xFF040308),
    onBackground = Color(0xFFF2EFE9),
    error = Color(0xFFFF1568),
    surface = Color(0xFF1D1D28),
    onSurface = Color(0xFFF2EFE9),
    surfaceVariant = Color(0xFF303041),
    onSurfaceVariant = Color(0xFFF2EFE9),
)

internal val materialDarkColors = darkColorScheme(
    onSurface = Color(0xFFF2EFE9),
)
