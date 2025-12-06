package app.allulith.routing.impl.data

import app.allulith.data.impl.OrganiserDatabase
import app.allulith.data.impl.entity.User
import app.allulith.routing.api.domain.RoutingRepository
import app.allulith.routing.api.domain.UserNotFound
import arrow.core.Either
import arrow.core.left
import arrow.core.right
import javax.inject.Inject

internal class RoutingRepositoryImpl @Inject constructor(
    private val database: OrganiserDatabase,
) : RoutingRepository {

    override suspend fun getUser(): Either<UserNotFound, User> {
        val user = database.userDao().getAll().firstOrNull()

        return user?.right() ?: UserNotFound.left()
    }
}
