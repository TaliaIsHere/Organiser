package app.allulith.routing.impl.di

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.navigation.api.Navigator
import app.allulith.routing.impl.routingNavigationBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.multibindings.IntoSet


@Module
@InstallIn(ActivityRetainedComponent::class)
internal object RoutingNavigationModule {

    @IntoSet
    @Provides
    fun provideRoutingNavigation() : EntryProviderScope<NavKey>.(Navigator) -> Unit = { navigator ->
        routingNavigationBuilder(navigator = navigator)
    }
}
