package app.allulith.ui.impl.theme.type

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle

@Immutable
data class OrganiserTypography(
    val header: TextStyle,
    val subHeader: TextStyle,
    val smallHeader: TextStyle,
    val body: TextStyle,
)

internal val LocalOrganiserTypography = staticCompositionLocalOf {
    OrganiserTypography(
        header = TextStyle.Default,
        subHeader = TextStyle.Default,
        smallHeader = TextStyle.Default,
        body = TextStyle.Default,
    )
}
