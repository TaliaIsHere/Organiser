package app.allulith.tasks.impl.di

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.tasks.impl.tasksNavigationBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(ActivityRetainedComponent::class)
internal object TasksNavigationModule {

    @IntoSet
    @Provides
    fun providesTasksNavigation() : EntryProviderScope<NavKey>.(SnapshotStateList<NavKey>) -> Unit = { backStack ->
        tasksNavigationBuilder(backStack = backStack)
    }
}
