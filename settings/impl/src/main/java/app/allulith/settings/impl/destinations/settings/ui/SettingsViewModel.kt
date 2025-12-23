package app.allulith.settings.impl.destinations.settings.ui

import android.content.Context
import androidx.compose.runtime.Stable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation3.runtime.NavKey
import app.allulith.settings.impl.destinations.settings.domain.SettingsRepository
import app.allulith.signup.api.destinations.SignUpDestination
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@Stable
@HiltViewModel(assistedFactory = SettingsViewModel.Factory::class)
internal class SettingsViewModel @AssistedInject constructor(
    @Assisted private val backStack: SnapshotStateList<NavKey>,
    @param:ApplicationContext val context: Context,
    private val repository: SettingsRepository,
) : ViewModel() {

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
        backStack.removeLastOrNull()
    }

    private fun deleteAccount() {
        viewModelScope.launch {
            repository.deleteAccount()
            backStack.clear()
            backStack.add(SignUpDestination.Welcome)
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

    @AssistedFactory
    interface Factory {
        fun create(backStack: SnapshotStateList<NavKey>): SettingsViewModel
    }
}
