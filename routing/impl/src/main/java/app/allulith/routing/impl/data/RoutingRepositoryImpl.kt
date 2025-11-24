package app.allulith.routing.impl.data

import app.allulith.data.impl.OrganiserDatabase
import app.allulith.data.impl.entity.User
import app.allulith.routing.api.domain.RoutingRepository
import javax.inject.Inject

internal class RoutingRepositoryImpl @Inject constructor(
    private val database: OrganiserDatabase,
) : RoutingRepository {

    override suspend fun getUser(): User? {
        return database.userDao().getAll().firstOrNull()
    }
}
