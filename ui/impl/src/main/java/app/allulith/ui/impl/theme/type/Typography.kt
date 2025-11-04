package app.allulith.ui.impl.theme.type

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

internal val typography = OrganiserTypography(
    header = TextStyle(
        fontSize = 36.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamilies.playfairDisplay,
        lineHeight = 44.sp,
    ),
    body = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamilies.ptSans,
        lineHeight = 18.sp,
    ),
)
