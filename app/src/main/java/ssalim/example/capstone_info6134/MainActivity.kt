package ssalim.example.capstone_info6134

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myFavoriteTeam= sharedPreference.getSavedTeam(this)

        if (myFavoriteTeam == null) {
            showYourFavoriteTeamDialog()
        }

    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    private fun showYourFavoriteTeamDialog() {

        val teamNames = resources.getStringArray(R.array.teams_List)
        val teamLogos = intArrayOf(
            R.drawable.mavericks,
            R.drawable.celtics,
            R.drawable.new_york_knicks_logo_primary_20129558,
            R.drawable.cavaliers,
            R.drawable.chicago_bulls_logo_primary_19672598
        )

        val spinner = Spinner(this)
        val adapter = TeamAdapter(this, teamNames, teamLogos)
        spinner.adapter = adapter


        AlertDialog.Builder(this)
            .setTitle("Pick Your Favorite Team")
            .setView(spinner)
            .setPositiveButton("Go Team!") { dialog, which ->
                val selectedTeam = spinner.selectedItem.toString()
                val teamIndex = teamNames.indexOf(selectedTeam)
                val homeGround = resources.getStringArray(R.array.teams_homeground)[teamIndex]
                val wins = resources.getStringArray(R.array.teams_wins)[teamIndex]
                val coach = resources.getStringArray(R.array.teams_coach)[teamIndex]

                sharedPreference.saveTeam(this, selectedTeam, homeGround, wins, coach)
                sharedPreference.saveTeamScore(this, "10-5")
                sharedPreference.saveTeamResult(this, "WINNER")
            }
            .setNegativeButton("Maybe Later", null)
            .setCancelable(false)
            .show()
    }



    fun onCardClick(view: View) {
        when (view.id) {
            R.id.teamDetails -> {
                Toast.makeText(this, "Team Details", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, TeamDetails::class.java)
                startActivity(intent)
            }
            R.id.cardView2 -> {
                val randomFixtures = FixtureGenerator.generateRandomFixtures(3)
                val intent = Intent(this, TodayActivity::class.java)
                intent.putExtra("randomFixtures", randomFixtures.toTypedArray())
                startActivity(intent)
                Toast.makeText(this, "League Fixture", Toast.LENGTH_SHORT).show()
            }
            R.id.cardView3 -> {
                Toast.makeText(this, "Team Betting", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, BettingActivity::class.java)
                startActivity(intent)
            }
            R.id.cardView4 -> {
                Toast.makeText(this, "Achievements", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, AchievementsActivity::class.java)
                startActivity(intent)
            }
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_about -> {
                Toast.makeText(this, "About selected", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_fav -> {

                val intent= Intent(this,favouriteActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}