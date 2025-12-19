package app.allulith.home.api.destinations

import androidx.navigation3.runtime.NavKey

sealed class HomeDestination : NavKey {
    data object Home : HomeDestination()
}
