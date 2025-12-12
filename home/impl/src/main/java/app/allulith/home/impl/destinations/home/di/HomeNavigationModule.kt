package app.allulith.home.impl.destinations.home.di

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.home.impl.homeNavigationBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.multibindings.IntoSet


@Module
@InstallIn(ActivityRetainedComponent::class)
object FeatureAModule {

    @IntoSet
    @Provides
    fun provideHomeNavigation() : EntryProviderScope<NavKey>.() -> Unit = {
        homeNavigationBuilder()
    }
}
