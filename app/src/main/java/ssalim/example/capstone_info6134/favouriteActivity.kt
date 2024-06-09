package ssalim.example.capstone_info6134

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class favouriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)
        val teamNameTextView = findViewById<TextView>(R.id.tv_team_name)


        val savedTeamName = sharedPreference.getSavedTeam(this)

        teamNameTextView.text = "Team Name: $savedTeamName" ?: "No Team Chosen"

        findViewById<Button>(R.id.btn_delete).setOnClickListener {

            deleteFavoriteTeam()

            finish()
        }
    }

        private fun deleteFavoriteTeam() {
            sharedPreference.deleteTeam(this)
        }

}