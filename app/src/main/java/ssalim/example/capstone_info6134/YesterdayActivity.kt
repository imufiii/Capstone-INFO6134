package ssalim.example.capstone_info6134

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class YesterdayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yesterday)

        val buttonToday: Button = findViewById(R.id.buttonToday)
        buttonToday.setOnClickListener {
            val intent = Intent(this, TodayActivity::class.java)
            startActivity(intent)
        }

        val buttonTomorrow: Button = findViewById(R.id.buttonTomorrow)
        buttonTomorrow.setOnClickListener {
            val intent = Intent(this, UpcomingActivity::class.java)
            startActivity(intent)
        }

        val backTomorrow: Button = findViewById(R.id.backYesterday)
        backTomorrow.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}