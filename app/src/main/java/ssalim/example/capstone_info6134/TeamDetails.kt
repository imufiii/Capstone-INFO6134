package ssalim.example.capstone_info6134

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TeamDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_details)
        val savedTeamName = sharedPreference.getSavedTeam(this)
        val teamNameTextView: TextView = findViewById(R.id.textViewTeam)
        teamNameTextView.text = savedTeamName ?: "No Team Chosen"
        backFunction()
    }

    private fun backFunction() {
        val backButton: Button = findViewById(R.id.backBtn)
        backButton.setOnClickListener {
            finish()
        }
    }
}