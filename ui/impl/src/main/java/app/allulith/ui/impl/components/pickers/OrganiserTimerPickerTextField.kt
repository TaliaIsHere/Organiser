package app.allulith.ui.impl.components.pickers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.ui.impl.components.textfields.OrganiserTextField
import app.allulith.ui.impl.theme.OrganiserTheme
import java.util.Locale
import kotlin.String

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrganiserTimerPickerTextField(
    timePickerState: TimePickerState?,
    modifier: Modifier = Modifier,
    label: String,
    placeholder: String,
    onClick: () -> Unit,
    onClickLabel: String,
    isError: Boolean = false,
    errorText: String = "",
) {
    OrganiserTextField(
        text =  if (timePickerState == null) {
            ""
        } else {
            String.format(
                Locale.ROOT,
                "%02d:%02d", timePickerState.hour, timePickerState.minute,
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
                timePickerState = TimePickerState(
                    initialHour = 0,
                    initialMinute = 0,
                    is24Hour = false,
                ),
                label = "Default text field",
                placeholder = "",
                onClick = {},
                onClickLabel = "",
            )
            OrganiserTimerPickerTextField(
                timePickerState = TimePickerState(
                    initialHour = 0,
                    initialMinute = 0,
                    is24Hour = false,
                ),
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
