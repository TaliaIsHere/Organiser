package app.allulith.ui.impl.theme.dimen

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

@Immutable
data class OrganiserDimensions(
    val padding: OrganiserPadding,
)

internal val LocalOrganiserDimensions = staticCompositionLocalOf {
    OrganiserDimensions(
        padding = OrganiserPadding(
            small = 0.dp,
            medium = 0.dp,
            large = 0.dp,
        ),
    )
}
