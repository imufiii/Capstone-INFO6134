package ssalim.example.capstone_info6134

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UpcomingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upcoming)

        val buttonToday: Button = findViewById(R.id.buttonToday)
        buttonToday.setOnClickListener {
            val intent = Intent(this, TodayActivity::class.java)
            startActivity(intent)
        }

        val buttonYesterday: Button = findViewById(R.id.buttonYesterday)
        buttonYesterday.setOnClickListener {
            val intent = Intent(this, YesterdayActivity::class.java)
            startActivity(intent)
        }
        val backYesterday: Button = findViewById(R.id.backUpComing)
        backYesterday.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}