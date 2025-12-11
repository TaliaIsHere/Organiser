package app.allulith.ui.impl.components.appbars

import androidx.annotation.DrawableRes

data class OrganiserTopBarAction(
    val contentDescription: String,
    @param:DrawableRes val image: Int,
    val onClick: () -> Unit,
)
