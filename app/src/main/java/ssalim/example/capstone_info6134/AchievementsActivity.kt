package ssalim.example.capstone_info6134

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AchievementsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_achievements)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewAchievements)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val achievements = listOf(
            Achievement("First Bet Placed", "Place your first bet.", R.drawable.balllife, isLocked = false),
            Achievement("Winning Streak", "Win 5 bets in a row.", R.drawable.balllife, isLocked = false),
            Achievement("High Roller", "Bet a total of $1000 or more.", R.drawable.balllife, isLocked = false),
            Achievement("Perfect Prediction", "Predict the exact score of a game.", R.drawable.balllife, isLocked = false),
            Achievement("Underdog Victory", "Win a bet on a team with odds greater than 5.0.", R.drawable.balllife, isLocked = true),
            Achievement("Season Opener", "Watch the first game of the season.", R.drawable.balllife, isLocked = true),
            Achievement("All-Star Weekend", "Participate in All-Star Weekend events.", R.drawable.balllife, isLocked = true),
            Achievement("Finals Fever", "Watch all the games in the Finals series.", R.drawable.balllife, isLocked = true),
            Achievement("Team Loyalty", "Support the same team for an entire season.", R.drawable.balllife, isLocked = true),
            Achievement("Social Butterfly", "Share your achievements on social media.", R.drawable.balllife, isLocked = true)
        )

        val adapter = AchievementsAdapter(achievements)
        recyclerView.adapter = adapter
    }
}
