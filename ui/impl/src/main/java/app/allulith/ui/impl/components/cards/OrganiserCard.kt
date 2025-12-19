package app.allulith.ui.impl.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.ui.impl.R
import app.allulith.ui.impl.text.OrganiserBodyText
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
fun OrganiserCustomCard(
    onClick: () -> Unit,
    content: @Composable ColumnScope.() -> Unit,
) {
    Card(
        onClick = onClick,
        shape = OrganiserCardDefaults.shape,
        colors = OrganiserCardDefaults.colors,
        content = content,
    )
}

@Composable
fun OrganiserRowCard(
    onClick: () -> Unit,
    text: String,
) {
    OrganiserCustomCard (
        onClick = onClick,
        content = {
            Row(
                modifier = Modifier.padding(OrganiserTheme.dimensions.padding.medium),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = text,
                    modifier = Modifier.weight(1f),
                    style = OrganiserCardDefaults.textStyle,
                    color = OrganiserCardDefaults.colors.contentColor,
                )
                Icon(
                    painter = painterResource(R.drawable.ic_chevron),
                    contentDescription = null,
                    tint = OrganiserTheme.colors.onSurface,
                )
            }
        },
    )
}

@PreviewLightDark
@Composable
private fun OrganiserCardPreview() {
    OrganiserTheme {
        Column(
            modifier = Modifier.background(OrganiserTheme.colors.background),
            verticalArrangement = Arrangement.spacedBy(OrganiserTheme.dimensions.padding.small),
        ) {
            OrganiserCustomCard(
                onClick = {},
                content = {
                    Column(
                        modifier = Modifier.padding(
                            OrganiserTheme.dimensions.padding.medium,
                        )
                    ) {
                        OrganiserBodyText(text = "CUSTOM!")
                    }
                },
            )

            OrganiserRowCard(
                onClick = {},
                text = "Row",
            )
        }
    }
}
