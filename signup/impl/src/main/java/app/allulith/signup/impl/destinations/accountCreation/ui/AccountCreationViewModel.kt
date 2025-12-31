package app.allulith.signup.impl.destinations.accountCreation.ui

import androidx.compose.runtime.Stable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation3.runtime.NavKey
import app.allulith.home.api.destinations.HomeDestination
import app.allulith.signup.impl.destinations.accountCreation.domain.AccountCreationRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@Stable
@HiltViewModel(assistedFactory = AccountCreationViewModel.Factory::class)
internal class AccountCreationViewModel @AssistedInject constructor(
    @Assisted private val backStack: SnapshotStateList<NavKey>,
    private val repository: AccountCreationRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(AccountCreation.UiState())
    val uiState = _uiState.asStateFlow()

    fun onUiEvent(uiEvent: AccountCreation.UiEvent) {
        when (uiEvent) {
            is AccountCreation.UiEvent.OnNameChange -> onNameChange(text = uiEvent.text)
            AccountCreation.UiEvent.OnCreateAccount -> createAccount()
        }
    }

    private fun onNameChange(text: String) {
        _uiState.update {
            it.copy(
                name = text,
                error = false,
            )
        }
    }

    private fun createAccount() {
        val name = uiState.value.name
        if (name.isBlank()) {
            _uiState.update { it.copy(error = true) }
        } else {
            viewModelScope.launch {
                repository.createUser(name = name)
                backStack.clear()
                backStack.add(HomeDestination.Home)
            }
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(backStack: SnapshotStateList<NavKey>): AccountCreationViewModel
    }
}
