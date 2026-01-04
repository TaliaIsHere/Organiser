package app.allulith.ui.impl.components.pickers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.ui.impl.components.textfields.OrganiserTextField
import app.allulith.ui.impl.theme.OrganiserTheme
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrganiserTimerPickerTextField(
    hour: Int?,
    minute: Int?,
    modifier: Modifier = Modifier,
    label: String,
    placeholder: String,
    onClick: () -> Unit,
    onClickLabel: String,
    isError: Boolean = false,
    errorText: String = "",
) {
    OrganiserTextField(
        text =  if (hour == null && minute == null) {
            ""
        } else {
            String.format(
                Locale.ROOT,
                "%02d:%02d", hour, minute,
            )
        },
        onValueChange = {},
        onFieldClick = {
            onClick()
        },
        fieldClickLabel = onClickLabel,
        modifier = modifier,
        label = label,
        placeholder = placeholder,
        isError = isError,
        errorText = errorText,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@PreviewLightDark
@Composable
private fun OrganiserTextFieldPreview() {
    OrganiserTheme {
        Column(
            modifier = Modifier.background(OrganiserTheme.colors.background),
            verticalArrangement = Arrangement.spacedBy(OrganiserTheme.dimensions.dim200),
        ) {
            OrganiserTimerPickerTextField(
                hour = 0,
                minute = 0,
                label = "Default text field",
                placeholder = "",
                onClick = {},
                onClickLabel = "",
            )
            OrganiserTimerPickerTextField(
                hour = 0,
                minute = 0,
                label = "Error text field",
                onClick = {},
                isError = true,
                errorText = "Error",
                placeholder = "",
                onClickLabel = "",
            )
        }
    }
}
