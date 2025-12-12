package app.allulith.ui.impl.components.appbars

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.ui.impl.R
import app.allulith.ui.impl.text.OrganiserBodyText
import app.allulith.ui.impl.theme.OrganiserTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrganiserTopBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    onBack: (() -> Unit)? = null,
    actions: List<OrganiserTopBarAction>? = null,
) {
    TopAppBar(
        title = {
            title?.let { OrganiserBodyText(text = it) }
        },
        modifier = modifier,
        navigationIcon = {
            if (onBack != null) {
                IconButton(
                    onClick = onBack,
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_back),
                        contentDescription = stringResource(R.string.cd_top_bar_back),
                        tint = OrganiserTheme.colors.onBackground,
                    )
                }
            }
        },
        actions = {
            actions?.forEach { action ->
                IconButton(
                    onClick = action.onClick,
                ) {
                    Icon(
                        painter = painterResource(action.image),
                        contentDescription = action.contentDescription,
                        tint = OrganiserTopBarDefaults.colors.actionIconContentColor,
                    )
                }
            }
        },
        colors = OrganiserTopBarDefaults.colors,
    )
}

@PreviewLightDark
@Composable
private fun OrganiserTopBarPreview() {
    OrganiserTheme {
        OrganiserTopBar(
            title = "Title",
            onBack = {},
            actions = listOf(
                OrganiserTopBarAction(
                    contentDescription = "",
                    image = R.drawable.ic_back,
                    onClick = {},
                )
            ),
        )
    }
}