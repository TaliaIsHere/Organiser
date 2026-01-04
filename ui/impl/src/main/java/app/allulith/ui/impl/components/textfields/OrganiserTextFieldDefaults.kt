package app.allulith.ui.impl.components.textfields

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import app.allulith.ui.impl.theme.OrganiserTheme

internal object OrganiserTextFieldDefaults {

    // TODO handle dropDown error state
    @Composable
    fun getColors(
        dropDown: Boolean,
    ): TextFieldColors {
        return TextFieldDefaults.colors(
            focusedTextColor = OrganiserTheme.colors.onSurface,
            unfocusedTextColor = OrganiserTheme.colors.onSurface,
            disabledTextColor = OrganiserTheme.colors.onSurface.copy(alpha = if (dropDown) 1f else 0.5f),
            errorTextColor = OrganiserTheme.colors.error,
            focusedContainerColor = OrganiserTheme.colors.surface,
            unfocusedContainerColor = OrganiserTheme.colors.surface,
            disabledContainerColor = OrganiserTheme.colors.surface.copy(alpha = if (dropDown) 1f else 0.5f),
            errorContainerColor = OrganiserTheme.colors.surface,
            cursorColor = OrganiserTheme.colors.primary,
            errorCursorColor = OrganiserTheme.colors.error,
            selectionColors = TextSelectionColors(
                handleColor = OrganiserTheme.colors.primary,
                backgroundColor = OrganiserTheme.colors.primary,
            ),
            focusedIndicatorColor = OrganiserTheme.colors.primary,
            unfocusedIndicatorColor = OrganiserTheme.colors.onSurface,
            disabledIndicatorColor = OrganiserTheme.colors.onSurface.copy(alpha = if (dropDown) 1f else 0.5f),
            errorIndicatorColor = OrganiserTheme.colors.error,
            focusedLeadingIconColor = OrganiserTheme.colors.primary,
            unfocusedLeadingIconColor = OrganiserTheme.colors.primary,
            disabledLeadingIconColor = OrganiserTheme.colors.primary.copy(alpha = if (dropDown) 1f else 0.5f),
            errorLeadingIconColor = OrganiserTheme.colors.error,
            focusedTrailingIconColor = OrganiserTheme.colors.primary,
            unfocusedTrailingIconColor = OrganiserTheme.colors.primary,
            disabledTrailingIconColor = OrganiserTheme.colors.primary.copy(alpha = if (dropDown) 1f else 0.5f),
            errorTrailingIconColor = OrganiserTheme.colors.error,
            focusedLabelColor = OrganiserTheme.colors.onBackground,
            unfocusedLabelColor = OrganiserTheme.colors.onBackground,
            disabledLabelColor = OrganiserTheme.colors.onBackground.copy(alpha = if (dropDown) 1f else 0.5f),
            errorLabelColor = OrganiserTheme.colors.error,
            focusedPlaceholderColor = OrganiserTheme.colors.onSurface.copy(alpha = 0.5f),
            unfocusedPlaceholderColor = OrganiserTheme.colors.onSurface.copy(alpha = 0.5f),
            disabledPlaceholderColor = OrganiserTheme.colors.onSurface.copy(alpha = 0.5f),
            errorPlaceholderColor = OrganiserTheme.colors.onSurface.copy(alpha = 0.5f),
            focusedSupportingTextColor = OrganiserTheme.colors.onBackground,
            unfocusedSupportingTextColor = OrganiserTheme.colors.onBackground,
            disabledSupportingTextColor = OrganiserTheme.colors.onBackground.copy(alpha = if (dropDown) 1f else 0.5f),
            errorSupportingTextColor = OrganiserTheme.colors.error,
            focusedPrefixColor = OrganiserTheme.colors.onSurface,
            unfocusedPrefixColor = OrganiserTheme.colors.onSurface,
            disabledPrefixColor = OrganiserTheme.colors.onSurface.copy(alpha = if (dropDown) 1f else 0.5f),
            errorPrefixColor = OrganiserTheme.colors.error,
            focusedSuffixColor = OrganiserTheme.colors.onSurface,
            unfocusedSuffixColor = OrganiserTheme.colors.onSurface,
            disabledSuffixColor = OrganiserTheme.colors.onSurface.copy(alpha = if (dropDown) 1f else 0.5f),
            errorSuffixColor = OrganiserTheme.colors.error,
        )
    }

    val textStyle: TextStyle
        @Composable
        get() = OrganiserTheme.typography.body

    val height: Dp
        @Composable
        get() = OrganiserTheme.dimensions.dim700

    val shape: RoundedCornerShape
        @Composable
        get() = RoundedCornerShape(OrganiserTheme.dimensions.dim100)
}
