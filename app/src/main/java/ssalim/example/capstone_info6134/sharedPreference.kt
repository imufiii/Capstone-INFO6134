package ssalim.example.capstone_info6134

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AlertDialog

object sharedPreference {

    private const val PREF_NAME = "app_prefs"
    private const val KEY_FAVORITE_TEAM = "favorite_team"
    private const val KEY_TEAM_SCORE = "team_score"
    private const val KEY_TEAM_RESULT = "team_result"
    private const val KEY_HOME_GROUND = "home_ground"
    private const val KEY_WINS = "wins"
    private const val KEY_COACH = "coach"

    interface DeleteTeamCallback {
        fun onTeamDeleted()
    }

    fun saveTeam(context: Context, team: String,  homeGround: String, wins: String, coach: String) {
        val preferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString(KEY_FAVORITE_TEAM, team)
        editor.putString(KEY_HOME_GROUND, homeGround)
        editor.putString(KEY_WINS, wins)
        editor.putString(KEY_COACH, coach)
        editor.apply()
    }
    fun saveTeamScore(context: Context, score: String) {
        val preferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString(KEY_TEAM_SCORE, score)
        editor.apply()
    }

    fun getSavedHomeGround(context: Context): String? {
        val preferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return preferences.getString(KEY_HOME_GROUND, null)
    }

    fun getSavedWins(context: Context): String? {
        val preferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return preferences.getString(KEY_WINS, null)
    }

    fun getSavedCoach(context: Context): String? {
        val preferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return preferences.getString(KEY_COACH, null)
    }

    fun saveTeamResult(context: Context, result: String) {
        val preferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString(KEY_TEAM_RESULT, result)
        editor.apply()
    }

    fun getSavedTeam(context: Context): String? {
        val preferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return preferences.getString(KEY_FAVORITE_TEAM, null)
    }

    fun getTeamScore(context: Context): String? {
        val preferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return preferences.getString(KEY_TEAM_SCORE, null)
    }

    fun getTeamResult(context: Context): String? {
        val preferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return preferences.getString(KEY_TEAM_RESULT, null)
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
                editor.remove(KEY_HOME_GROUND)
                editor.remove(KEY_WINS)
                editor.remove(KEY_COACH)
                editor.apply()
                callback.onTeamDeleted()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }



}