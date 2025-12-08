package app.allulith.signup.impl.destinations.accountCreation.domain

internal interface AccountCreationRepository {
    suspend fun createUser(name: String)
}
