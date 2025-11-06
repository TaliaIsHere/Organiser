package app.allulith.organiser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import app.allulith.ui.impl.theme.OrganiserTheme
import app.allulith.ui.impl.templates.OrganiserScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            OrganiserTheme {
                OrganiserScreen(
                    header = "Organiser",
                    description = "Welcome to Organiser...",
                ) {}
            }
        }
    }
}
