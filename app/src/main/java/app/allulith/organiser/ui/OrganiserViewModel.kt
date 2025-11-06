package app.allulith.organiser.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.allulith.organiser.domain.OrganiserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class OrganiserViewModel @Inject constructor(
    organiserRepository: OrganiserRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(Organiser.UiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val user = organiserRepository.getUser()

            _uiState.value = Organiser.UiState(
                startRoute = when (user == null) {
                    true -> "signup"
                    false -> "home"
                },
            )
        }
    }
}
