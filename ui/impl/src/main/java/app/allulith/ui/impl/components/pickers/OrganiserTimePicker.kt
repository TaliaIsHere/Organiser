package app.allulith.ui.impl.components.pickers

import android.icu.util.Calendar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.ui.impl.components.buttons.OrganiserButton
import app.allulith.ui.impl.theme.OrganiserTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrganiserTimePicker(
    hour: Int?,
    minute: Int?,
    onConfirm: (TimePickerState) -> Unit,
    onDismiss: () -> Unit,
    is24Hour: Boolean = true,
) {
    val state = rememberTimePickerState(
        initialHour = hour ?: Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
        initialMinute = minute ?:Calendar.getInstance().get(Calendar.MINUTE),
        is24Hour = is24Hour,
    )

    Column(
        modifier = Modifier.width(IntrinsicSize.Min),
        verticalArrangement = Arrangement.spacedBy(OrganiserTheme.dimensions.dim100),
    ) {
        TimePicker(
            state = state,
            // TODO my colors
            colors = TimePickerDefaults.colors(),
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Spacer(Modifier.weight(1f))
            OrganiserButton(
                text = "Dismiss",
                onClick = onDismiss,
            )
            Spacer(Modifier.width(OrganiserTheme.dimensions.dim150))
            OrganiserButton(
                text = "Confirm",
                onClick = {
                    onConfirm(state)
                },
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@PreviewLightDark
@Composable
private fun OrganiserTimePickerPreview() {
    OrganiserTheme {
        OrganiserTimePicker(
            hour = null,
            minute = null,
            onConfirm = {},
            onDismiss = {},
        )
    }
}
