package ssalim.example.capstone_info6134

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TodayActivity : AppCompatActivity() {

    private lateinit var fixtures: List<Fixture>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_today)
        val backButton: Button = findViewById(R.id.backToday)

        fixtures = FixtureGenerator.generateRandomFixtures(5)
        displayFixtures()

        val buttonYesterday: Button = findViewById(R.id.buttonYesterday)
        buttonYesterday.setOnClickListener {
            startActivity(Intent(this, YesterdayActivity::class.java))
        }

        val buttonTomorrow: Button = findViewById(R.id.buttonTomorrow)
        buttonTomorrow.setOnClickListener {
            startActivity(Intent(this, UpcomingActivity::class.java))
        }

        backButton.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java )
            startActivity(intent)
        }
    }

    private fun displayFixtures() {
        val textTeamHome1: TextView = findViewById(R.id.textTeamHome1)
        val textTeamAway1: TextView = findViewById(R.id.textTeamAway1)
        val textGameNumber1: TextView = findViewById(R.id.textGameNumber1)
        val textVenue1: TextView = findViewById(R.id.textVenue1)
        val textTime1: TextView = findViewById(R.id.textTime1)
        val textLeague1: TextView = findViewById(R.id.textLeague1)
        val imageViewHome1: ImageView = findViewById(R.id.imageView_home_1)
        val imageViewAway1: ImageView = findViewById(R.id.imageView_away_1)

        textTeamHome1.text = fixtures[0].teamHome
        textTeamAway1.text = fixtures[0].teamAway
        textGameNumber1.text = fixtures[0].gameNumber
        textVenue1.text = fixtures[0].venue
        textTime1.text = fixtures[0].time
        textLeague1.text = fixtures[0].league
        imageViewHome1.setImageResource(fixtures[0].teamHomeLogo)
        imageViewAway1.setImageResource(fixtures[0].teamAwayLogo)

    }
}
