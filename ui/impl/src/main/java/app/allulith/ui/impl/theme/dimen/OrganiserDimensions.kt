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
            pad050 = 0.dp,
            pad100 = 0.dp,
            pad150 = 0.dp,
            pad200 = 0.dp,
            pad250 = 0.dp,
            pad300 = 0.dp,
            pad350 = 0.dp,
            pad400 = 0.dp,
        ),
    )
}
