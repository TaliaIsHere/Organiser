package app.allulith.settings.impl.destinations.settings.di

import app.allulith.settings.impl.destinations.settings.data.SettingsRepositoryImpl
import app.allulith.settings.impl.destinations.settings.domain.SettingsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class SettingsModule {

    @Binds
    @Singleton
    abstract fun bindRepository(
        repository: SettingsRepositoryImpl
    ): SettingsRepository
}
