package app.allulith.routing.api.domain

import app.allulith.data.impl.entity.User
import arrow.core.Either

interface RoutingRepository {

    suspend fun getUser(): Either<UserNotFound, User>
}
