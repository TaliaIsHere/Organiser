package app.allulith.ui.impl.theme.dimen

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Works on a percentage scale with the default measurement being 8.dp therefore,
 * dim200 is 200% of 8.dp equaling 16.dp this can be applied to all other measurements
 */
@Immutable
data class OrganiserDimensions(
    val dim050: Dp,
    val dim100: Dp,
    val dim150: Dp,
    val dim200: Dp,
    val dim250: Dp,
    val dim300: Dp,
    val dim350: Dp,
    val dim400: Dp,
)
internal val LocalOrganiserDimensions = staticCompositionLocalOf {
    OrganiserDimensions(
        dim050 = 0.dp,
        dim100 = 0.dp,
        dim150 = 0.dp,
        dim200 = 0.dp,
        dim250 = 0.dp,
        dim300 = 0.dp,
        dim350 = 0.dp,
        dim400 = 0.dp,
    )
}
