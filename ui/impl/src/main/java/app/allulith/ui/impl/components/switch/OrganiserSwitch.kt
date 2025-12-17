package app.allulith.ui.impl.components.switch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.ui.impl.R
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
fun OrganiserSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        thumbContent = {
            if (checked) {
                Icon(
                    painter = painterResource(R.drawable.ic_tick),
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            } else {
                Icon(
                    painter = painterResource(R.drawable.ic_close),
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        },
        enabled = enabled,
        colors = OrganiserSwitchDefaults.colors,
    )
}

@PreviewLightDark
@Composable
private fun OrganiserSwitchPreview() {
    OrganiserTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(
                OrganiserTheme.dimensions.padding.small,
            ),
        ) {
            OrganiserSwitch(
                checked = true,
                onCheckedChange = {},
            )

            OrganiserSwitch(
                checked = false,
                onCheckedChange = {},
            )

            OrganiserSwitch(
                checked = true,
                onCheckedChange = {},
                enabled = false,
            )

            OrganiserSwitch(
                checked = false,
                onCheckedChange = {},
                enabled = false,
            )
        }
    }
}
