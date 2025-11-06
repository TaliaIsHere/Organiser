package app.allulith.organiser.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.allulith.ui.impl.templates.OrganiserScreen
import app.allulith.ui.impl.theme.OrganiserTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class OrganiserActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val viewModel: OrganiserViewModel = hiltViewModel()
            val uiState = viewModel.uiState.collectAsStateWithLifecycle().value
            val backStack = remember { mutableStateListOf<Any>() }

            OrganiserTheme {
                if (uiState.startRoute != null) {
                    when (uiState.startRoute) {
                        else -> {
                            OrganiserScreen(
                                header = "Welcome to Organiser...",
                                description = "This is a description",
                            ) { }
                        }
                    }
                }
            }
        }
    }
}
