package app.allulith.organiser.domain

import app.allulith.data.impl.entity.User

internal interface OrganiserRepository {

    suspend fun getUser(): User?
}
