package app.allulith.routing.impl.domain

import app.allulith.data.impl.entity.User

interface RoutingRepository {

    suspend fun getUser(): User?
}
