package app.allulith.home.impl.destinations.home.ui

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.allulith.home.impl.destinations.home.domain.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@Stable
@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val repository: HomeRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(Home.UiState())
    val uiState = _uiState.asStateFlow()

    init {
        personalizeHome()
    }

    private fun personalizeHome() {
        viewModelScope.launch {
            repository.getUserName().onRight { name ->
                _uiState.update { it.copy(name = name) }
            }
        }
    }
}
