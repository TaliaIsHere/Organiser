package app.allulith.data.impl.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

object ThemeManager {

    private val THEME_KEY = booleanPreferencesKey("theme_preference")

    suspend fun getCurrentTheme(context: Context): Boolean {
        val preferences = context.dataStore.data.first()
        return preferences[THEME_KEY] ?: false
    }

    suspend fun setTheme(context: Context, isDarkTheme: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[THEME_KEY] = isDarkTheme
        }
    }
}
