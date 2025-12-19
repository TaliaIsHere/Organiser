package app.allulith.signup.api.destinations

import androidx.navigation3.runtime.NavKey

sealed class SignUpDestination : NavKey {
    data object Welcome : SignUpDestination()
    data object AccountCreation : SignUpDestination()
}
