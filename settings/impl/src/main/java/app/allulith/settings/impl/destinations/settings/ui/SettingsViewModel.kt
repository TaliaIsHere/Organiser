package app.allulith.settings.impl.destinations.settings.ui

import android.content.Context
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.allulith.settings.impl.destinations.settings.domain.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@Stable
@HiltViewModel
internal class SettingsViewModel @Inject constructor(
    @param:ApplicationContext val context: Context,
    private val repository: SettingsRepository,
) : ViewModel() {

    private val eventsChannel: Channel<Settings.Event> = Channel(Channel.BUFFERED)
    val eventsFlow = eventsChannel.receiveAsFlow()

    private val _uiState = MutableStateFlow(
        Settings.UiState(
            version = getVersion(context = context) ?: ""
        )
    )

    val uiState = _uiState.asStateFlow()

    fun onUiEvent(uiEvent: Settings.UiEvent) {
        when (uiEvent) {
            Settings.UiEvent.OnBack -> goBack()
            Settings.UiEvent.OnDeleteAccount -> deleteAccount()
        }
    }

    private fun goBack() {
        viewModelScope.launch {
            eventsChannel.send(Settings.Event.GoBack)
        }
    }

    private fun deleteAccount() {
        viewModelScope.launch {
            repository.deleteAccount()
            eventsChannel.send(Settings.Event.NavigateToRouting)
        }
    }

    private fun getVersion(context: Context): String? {
        try {
            val packageManager = context.packageManager
            val packageName = context.packageName
            val info = packageManager.getPackageInfo(packageName, 0)

            return info.versionName
        } catch (_: Exception) {
            return null
        }
    }
}
