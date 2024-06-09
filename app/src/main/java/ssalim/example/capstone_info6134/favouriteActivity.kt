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
        val selectedTeam = intent.getStringExtra("TEAM_NAME")


        teamNameTextView.text = "Team Name: $selectedTeam"
        val deleteButton = findViewById<Button>(R.id.btn_delete)
        deleteButton.setOnClickListener {
            deleteFavoriteTeam(this)
            finish()
        }
    }

        private fun deleteFavoriteTeam(context: Context) {
            sharedPreference.deleteTeam(context)
        }

}