package app.allulith.ui.impl.theme.type

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import app.allulith.ui.impl.R

val poiretOne = FontFamily(
    Font(R.font.poiret_one_regular)
)

val ptSans = FontFamily(
    Font(R.font.pt_sans_regular),
    Font(R.font.pt_sans_bold, FontWeight.Bold)
)

val playfairDisplay = FontFamily(
    Font(R.font.playfair_display_regular),
    Font(R.font.playfair_display_medium, FontWeight.Medium),
    Font(R.font.playfair_display_semibold, FontWeight.SemiBold),
    Font(R.font.playfair_display_bold, FontWeight.Bold),
    Font(R.font.playfair_display_black, FontWeight.Black)
)
