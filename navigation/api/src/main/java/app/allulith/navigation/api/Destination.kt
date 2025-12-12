package app.allulith.navigation.api

import androidx.navigation3.runtime.NavKey

sealed class Destination : NavKey {
    data object Routing : Destination()
    data object SignUp : Destination()
    data object Home : Destination()
    data object Settings : Destination()
}
