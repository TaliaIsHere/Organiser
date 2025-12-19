package app.allulith.routing.impl.destinations.routing.domain

import app.allulith.data.impl.entity.User
import arrow.core.Either

internal interface RoutingRepository {

    suspend fun getUser(): Either<UserNotFound, User>
}
