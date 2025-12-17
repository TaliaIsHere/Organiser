package app.allulith.settings.impl.destinations.settings.data

import app.allulith.data.impl.OrganiserDatabase
import app.allulith.settings.impl.destinations.settings.domain.SettingsRepository
import javax.inject.Inject

internal class SettingsRepositoryImpl @Inject constructor(
    private val database: OrganiserDatabase,
) : SettingsRepository {

    override suspend fun deleteAccount() {
        val user = database.userDao().getAll().first()
        database.userDao().delete(user)
    }
}
