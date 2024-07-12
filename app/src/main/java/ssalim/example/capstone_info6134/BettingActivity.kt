package ssalim.example.capstone_info6134

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class BettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_betting)

        // Sample achievements data
        val achievements = "You won 5 games!"

        val btnViewAchievements: Button = findViewById(R.id.btnViewAchievements)
        btnViewAchievements.setOnClickListener {
            val intent = Intent(this, AchievementsActivity::class.java)
            intent.putExtra("ACHIEVEMENTS", achievements)
            startActivity(intent)
        }
    }
}
