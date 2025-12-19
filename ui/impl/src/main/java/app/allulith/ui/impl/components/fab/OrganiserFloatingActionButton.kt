package app.allulith.ui.impl.components.fab

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.ui.impl.R
import app.allulith.ui.impl.text.OrganiserBodyText
import app.allulith.ui.impl.theme.OrganiserTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrganiserFloatingActionButton(
    onClick: () -> Unit,
    toolTip: String,
    @DrawableRes icon: Int,
    iconDescription: String,
) {
    TooltipBox(
        positionProvider =
            TooltipDefaults.rememberTooltipPositionProvider(TooltipAnchorPosition.Above),
        tooltip = {
            PlainTooltip {
                OrganiserBodyText(text = toolTip)
            }
        },
        state = rememberTooltipState(),
    ) {
        FloatingActionButton(
            onClick = onClick,
            containerColor = OrganiserFloatingActionButtonDefaults.containerColor,
            contentColor = OrganiserFloatingActionButtonDefaults.contentColor,
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = iconDescription,
                tint = OrganiserFloatingActionButtonDefaults.contentColor,
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun OrganiserFloatingActionButtonPreview() {
    OrganiserTheme {
        OrganiserFloatingActionButton(
            onClick = {},
            toolTip = "Floating action button",
            icon = R.drawable.ic_close,
            iconDescription = "Sample",
        )
    }
}
