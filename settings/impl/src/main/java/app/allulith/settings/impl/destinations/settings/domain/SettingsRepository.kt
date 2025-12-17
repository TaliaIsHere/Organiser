package app.allulith.settings.impl.destinations.settings.domain

internal interface SettingsRepository {
    suspend fun deleteAccount()
}
