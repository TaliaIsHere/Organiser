package app.allulith.navigation.api

sealed class Destination {
    data object SignUpDestination : Destination()
    data object Home : Destination()
}
