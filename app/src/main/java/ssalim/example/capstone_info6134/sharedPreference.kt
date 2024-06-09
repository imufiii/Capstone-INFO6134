package ssalim.example.capstone_info6134

import android.content.Context
import android.content.SharedPreferences

object sharedPreference {

    private const val PREF_NAME = "app_prefs"
    private const val KEY_FAVORITE_TEAM = "favorite_team"


    fun saveTeam(context: Context, team: String) {
        val preferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString(KEY_FAVORITE_TEAM, team)
        editor.apply()
    }


    fun getSavedTeam(context: Context): String? {
        val preferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return preferences.getString(KEY_FAVORITE_TEAM, null)
    }
}