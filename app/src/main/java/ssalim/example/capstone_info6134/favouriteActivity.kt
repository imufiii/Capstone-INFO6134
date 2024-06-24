package ssalim.example.capstone_info6134

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class favouriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)
        val teamNameTextView = findViewById<TextView>(R.id.tv_team_name)
        val homeGroundTextView = findViewById<TextView>(R.id.tv_homeground)
        val winsTextView = findViewById<TextView>(R.id.tv_no_of_wins)
        val coachTextView = findViewById<TextView>(R.id.tv_coach)
        val teamLogoImageView = findViewById<ImageView>(R.id.team_logo)


        val savedTeamName = sharedPreference.getSavedTeam(this)
        val savedHomeGround = sharedPreference.getSavedHomeGround(this)
        val savedWins = sharedPreference.getSavedWins(this)
        val savedCoach = sharedPreference.getSavedCoach(this)
        val teamNames = resources.getStringArray(R.array.teams_List)
        val teamLogos = intArrayOf(
            R.drawable.mavericks,
            R.drawable.celtics,
            R.drawable.new_york_knicks_logo_primary_20129558,
            R.drawable.cavaliers,
            R.drawable.chicago_bulls_logo_primary_19672598
        )

        val teamIndex = savedTeamName?.let { teamNames.indexOf(it) } ?: -1

        if (teamIndex != -1) {
            teamNameTextView.text = "Team Name: $savedTeamName"
            homeGroundTextView.text = "Home Ground: $savedHomeGround"
            winsTextView.text = "Wins: $savedWins"
            coachTextView.text = "Coach: $savedCoach"
            teamLogoImageView.setImageResource(teamLogos[teamIndex])
            findViewById<Button>(R.id.btn_delete).visibility = View.VISIBLE
        } else {
            findViewById<Button>(R.id.btn_delete).visibility = View.GONE
            teamNameTextView.text = "No Team Chosen"
            homeGroundTextView.visibility = View.GONE
            winsTextView.visibility = View.GONE
            coachTextView.visibility = View.GONE
        }

        findViewById<Button>(R.id.btn_delete).setOnClickListener {

            showConfirmationDialog()
        }
        findViewById<Button>(R.id.btn_back).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showConfirmationDialog() {
        sharedPreference.deleteTeam(this, this)
    }

    fun onTeamDeleted() {
        finish()
    }

}