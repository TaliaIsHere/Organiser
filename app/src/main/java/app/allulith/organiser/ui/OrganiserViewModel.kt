package app.allulith.organiser.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.allulith.organiser.domain.OrganiserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class OrganiserViewModel @Inject constructor(
    organiserRepository: OrganiserRepository,
) : ViewModel() {
    init {
        viewModelScope.launch {
            val user = organiserRepository.getUser()

            Log.d("test_out", "User: $user")
        }
    }
}
