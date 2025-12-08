package app.allulith.signup.impl.destinations.accountCreation.ui

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.allulith.signup.impl.destinations.accountCreation.domain.AccountCreationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@Stable
@HiltViewModel
internal class AccountCreationViewModel @Inject constructor(
    private val repository: AccountCreationRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(AccountCreation.UiState())
    val uiState = _uiState.asStateFlow()

    private val eventsChannel: Channel<AccountCreation.Event> = Channel(Channel.BUFFERED)
    val eventsFlow = eventsChannel.receiveAsFlow()

    fun onUiEvent(uiEvent: AccountCreation.UiEvent) {
        when (uiEvent) {
            is AccountCreation.UiEvent.OnNameChange -> onNameChange(text = uiEvent.text)
            AccountCreation.UiEvent.OnCreateAccountTap -> createAccount()
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
                eventsChannel.send(AccountCreation.Event.NavigateToHome)
            }

        }
    }
}
