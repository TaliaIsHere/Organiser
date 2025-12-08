package app.allulith.signup.impl.destinations

internal sealed class SignUpDestination {
    data object Welcome : SignUpDestination()
    data object AccountCreation : SignUpDestination()
}
