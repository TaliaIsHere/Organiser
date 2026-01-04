package app.allulith.ui.impl.components.textfields

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.PreviewLightDark
import app.allulith.ui.impl.text.OrganiserBodyText
import app.allulith.ui.impl.text.OrganiserErrorText
import app.allulith.ui.impl.theme.OrganiserTheme

@Composable
fun OrganiserTextField(
    text: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String,
    placeholder: String,
    onFieldClick: (() -> Unit)? = null,
    fieldClickLabel: String? = null,
    isError: Boolean = false,
    errorText: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        capitalization = KeyboardCapitalization.Sentences,
    ),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(OrganiserTheme.dimensions.dim050)
    ) {
        OrganiserBodyText(
            text = label,
        )
        if (onFieldClick != null) {
            Box(
                modifier = Modifier.clickable(
                    onClick = onFieldClick,
                    onClickLabel = fieldClickLabel,
                    role = Role.Button,
                )
            ) {
                OutlinedTextField(
                    value = text,
                    onValueChange = onValueChange,
                    modifier = modifier
                        .defaultMinSize(minHeight = OrganiserTextFieldDefaults.height)
                        .clickable(onClick = onFieldClick),
                    enabled = false,
                    readOnly = true,
                    textStyle = OrganiserTextFieldDefaults.textStyle,
                    placeholder = {
                        Text(
                            text = placeholder,
                            style = OrganiserTheme.typography.body,
                        )
                    },
                    isError = isError,
                    keyboardOptions = keyboardOptions,
                    keyboardActions = keyboardActions,
                    shape = OrganiserTextFieldDefaults.shape,
                    colors = OrganiserTextFieldDefaults.getColors(dropDown = true),
                )
            }
        } else {
            OutlinedTextField(
                value = text,
                onValueChange = onValueChange,
                modifier = modifier
                    .defaultMinSize(minHeight = OrganiserTextFieldDefaults.height),
                textStyle = OrganiserTextFieldDefaults.textStyle,
                placeholder = {
                    Text(
                        text = placeholder,
                        style = OrganiserTheme.typography.body,
                    )
                },
                isError = isError,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                shape = OrganiserTextFieldDefaults.shape,
                colors = OrganiserTextFieldDefaults.getColors(dropDown = false),
            )
        }

        AnimatedVisibility(
            visible = isError,
        ) {
            OrganiserErrorText(
                text = errorText,
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun OrganiserTextFieldPreview() {
    OrganiserTheme {
        Column(
            modifier = Modifier.background(OrganiserTheme.colors.background),
            verticalArrangement = Arrangement.spacedBy(OrganiserTheme.dimensions.dim200),
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
                errorText = "Error",
                placeholder = "",
            )
            OrganiserTextField(
                text = "",
                onValueChange = {},
                label = "Placeholder text field",
                placeholder = "Placeholder",
            )
        }
    }
}
