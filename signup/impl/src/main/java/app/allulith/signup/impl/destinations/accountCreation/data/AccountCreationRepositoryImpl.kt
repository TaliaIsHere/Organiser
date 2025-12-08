package app.allulith.signup.impl.destinations.accountCreation.data

import app.allulith.data.impl.OrganiserDatabase
import app.allulith.data.impl.entity.User
import app.allulith.signup.impl.destinations.accountCreation.domain.AccountCreationRepository
import javax.inject.Inject
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

internal class AccountCreationRepositoryImpl @Inject constructor(
    private val database: OrganiserDatabase,
) : AccountCreationRepository {

    @OptIn(ExperimentalUuidApi::class)
    override suspend fun createUser(name: String) {
        val user = User(
            uid = Uuid.random().toString(),
            name = name,
        )

        database.userDao().insertAll(user)
    }
}
