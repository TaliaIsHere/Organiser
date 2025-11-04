package app.allulith.organiser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.allulith.ui.impl.theme.OrganiserTheme
import app.allulith.ui.impl.components.buttons.OrganiserButton
import app.allulith.ui.impl.templates.OrganiserScreen

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
