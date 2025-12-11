package app.allulith.navigation.api

sealed class Destination {
    data object Routing : Destination()
    data object SignUp : Destination()
    data object Home : Destination()
    data object Settings : Destination()
}
