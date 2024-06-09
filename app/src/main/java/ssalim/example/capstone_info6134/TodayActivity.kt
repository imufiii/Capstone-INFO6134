package ssalim.example.capstone_info6134

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TodayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_today)
        val buttonTomorrow: Button = findViewById(R.id.buttonTomorrow)
        val buttonYesterday: Button = findViewById(R.id.buttonYesterday)
        val backButton: Button = findViewById(R.id.backToday)

        buttonYesterday.setOnClickListener {
            val intent = Intent(this, YesterdayActivity::class.java)
            startActivity(intent)
        }

        buttonTomorrow.setOnClickListener {
            val intent = Intent(this, UpcomingActivity::class.java)
            startActivity(intent)

            }
        backButton.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java )
            startActivity(intent)
        }
    }
}