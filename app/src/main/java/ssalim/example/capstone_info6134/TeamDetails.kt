package ssalim.example.capstone_info6134

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TeamDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_details)

        val textViewTeam: TextView = findViewById(R.id.textViewTeam)
        val textViewScore: TextView = findViewById(R.id.textView6)
        val textViewResult: TextView = findViewById(R.id.textView8)

        val team = sharedPreference.getSavedTeam(this)
        val score = sharedPreference.getTeamScore(this)
        val result = sharedPreference.getTeamResult(this)

        textViewTeam.text = team ?: "No team saved"
        textViewScore.text = score ?: "No score"
        textViewResult.text = result ?: "No result"

        backFunction()
    }

    private fun backFunction() {
        val backButton: Button = findViewById(R.id.backBtn)
        backButton.setOnClickListener {
            finish()
        }
    }
}