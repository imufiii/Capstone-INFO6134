package ssalim.example.capstone_info6134

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class favouriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)
        val teamNameTextView = findViewById<TextView>(R.id.tv_team_name)


        val savedTeamName = sharedPreference.getSavedTeam(this)

        if (savedTeamName != null) {
            teamNameTextView.text = "Team Name: $savedTeamName"
            findViewById<Button>(R.id.btn_delete).visibility = View.VISIBLE
        } else {
            findViewById<Button>(R.id.btn_delete).visibility = View.GONE
            teamNameTextView.text = "No Team Chosen"
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