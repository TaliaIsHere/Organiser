package app.allulith.routing.api.domain

import app.allulith.data.impl.entity.User

interface RoutingRepository {

    suspend fun getUser(): User?
}
