package app.allulith.organiser.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.navigation3.runtime.NavKey
import app.allulith.routing.api.ui.RoutingDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * A very simple viewmodel to handle lifecycle changes of navigational state across the application
 */
@HiltViewModel
internal class OrganiserViewModel @Inject constructor() : ViewModel() {
    val backStack = mutableStateListOf<NavKey>(RoutingDestination.Routing)
}
