package app.allulith.notification.impl.di

import app.allulith.notification.api.domain.NotificationRepository
import app.allulith.notification.impl.data.NotificationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NotificationModule {

    @Binds
    @Singleton
    abstract fun bindRepository(
        repositoryImpl: NotificationRepositoryImpl
    ): NotificationRepository
}
