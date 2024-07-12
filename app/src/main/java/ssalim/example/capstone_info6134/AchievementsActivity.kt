package ssalim.example.capstone_info6134

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
class AchievementsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_achievements)

        val achievements = intent.getStringExtra("ACHIEVEMENTS") ?: "No achievements yet."

        val etAchievements: EditText = findViewById(R.id.etAchievements)
        etAchievements.setText(achievements)

        val btnSave: Button = findViewById(R.id.btnSave)
        btnSave.setOnClickListener {
            // Code to save the edited achievements
            val editedAchievements = etAchievements.text.toString()
            // You can save this data to a database or shared preferences
        }
    }
}
