package ssalim.example.capstone_info6134

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AlertDialog

object sharedPreference {

    private const val PREF_NAME = "app_prefs"
    private const val KEY_FAVORITE_TEAM = "favorite_team"
    interface DeleteTeamCallback {
        fun onTeamDeleted()
    }

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

    fun deleteTeam(context: Context, callback: favouriteActivity) {
        AlertDialog.Builder(context)
            .setTitle("Confirm Deletion")
            .setMessage("Are you sure you want to delete your favorite team?")
            .setPositiveButton("Delete") { dialog, which ->
                val preferences: SharedPreferences =
                    context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
                val editor = preferences.edit()
                editor.remove(KEY_FAVORITE_TEAM)
                editor.apply()
                callback.onTeamDeleted() // Invoke callback after deletion
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

}