package app.allulith.routing.impl.di

import android.content.Context
import app.allulith.data.impl.OrganiserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    fun provideOrganiserDatabase(@ApplicationContext context: Context): OrganiserDatabase {
        return OrganiserDatabase.getInstance(context)
    }
}
