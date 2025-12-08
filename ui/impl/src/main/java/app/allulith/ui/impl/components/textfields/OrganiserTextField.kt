package app.allulith.ui.impl.components.textfields

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.ui.impl.text.OrganiserBodyText
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
fun OrganiserTextField(
    text: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String,
    placeholder: String,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(OrganiserTheme.dimensions.padding.small)
    ) {
        OrganiserBodyText(
            text = label,
        )
        OutlinedTextField(
            value = text,
            onValueChange = onValueChange,
            modifier = modifier.defaultMinSize(minHeight = OrganiserTextFieldDefaults.height),
            textStyle = OrganiserTextFieldDefaults.textStyle,
            placeholder = {
                OrganiserBodyText(
                    text = placeholder,
                )
            },
            isError = isError,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            shape = OrganiserTextFieldDefaults.shape,
            colors = OrganiserTextFieldDefaults.colors,
        )
    }
}

@PreviewLightDark
@Composable
private fun OrganiserTextFieldPreview() {
    OrganiserTheme {
        Column(
            modifier = Modifier.background(OrganiserTheme.colors.background),
            verticalArrangement = Arrangement.spacedBy(OrganiserTheme.dimensions.padding.large),
        ) {
            OrganiserTextField(
                text = "Hi!",
                onValueChange = {},
                label = "Default text field",
                placeholder = "",
            )
            OrganiserTextField(
                text = "There is an error",
                onValueChange = {},
                label = "Error text field",
                isError = true,
                placeholder = "",
            )
        }
    }
}
