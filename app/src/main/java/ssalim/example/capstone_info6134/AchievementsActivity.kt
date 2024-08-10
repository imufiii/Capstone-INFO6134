package ssalim.example.capstone_info6134

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AchievementsActivity : AppCompatActivity() {

    private lateinit var achievements: MutableList<Achievement>
    private lateinit var adapter: AchievementsAdapter
    private var isFirstBetPlaced: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_achievements)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btnPlaceBet: Button = findViewById(R.id.btnPlaceBet)
        btnPlaceBet.setOnClickListener {
            showBettingDialog()
        }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewAchievements)
        recyclerView.layoutManager = LinearLayoutManager(this)

        achievements = mutableListOf(
            Achievement("First Bet Placed", "Place your first bet.", R.drawable.balllife, isLocked = true),
            Achievement("Winning Streak", "Win 5 bets in a row.", R.drawable.balllife, isLocked = true),
            Achievement("High Roller", "Bet a total of $1000 or more.", R.drawable.balllife, isLocked = true),
            Achievement("Perfect Prediction", "Predict the exact score of a game.", R.drawable.balllife, isLocked = true),
            Achievement("Underdog Victory", "Win a bet on a team with odds greater than 5.0.", R.drawable.balllife, isLocked = true),
            Achievement("Season Opener", "Watch the first game of the season.", R.drawable.balllife, isLocked = true),
            Achievement("All-Star Weekend", "Participate in All-Star Weekend events.", R.drawable.balllife, isLocked = true),
            Achievement("Finals Fever", "Watch all the games in the Finals series.", R.drawable.balllife, isLocked = true),
            Achievement("Team Loyalty", "Support the same team for an entire season.", R.drawable.balllife, isLocked = true),
            Achievement("Social Butterfly", "Share your achievements on social media.", R.drawable.balllife, isLocked = true)
        )

        adapter = AchievementsAdapter(achievements)
        recyclerView.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showBettingDialog() {
        val inflater = LayoutInflater.from(this)
        val bettingDialogView = inflater.inflate(R.layout.dialogu_betting, null)

        val radioGroupTeams = bettingDialogView.findViewById<RadioGroup>(R.id.radioGroupTeams)

        val dialog = AlertDialog.Builder(this)
            .setTitle("Place a Bet on a Team")
            .setView(bettingDialogView)
            .setPositiveButton("Place Bet") { _, _ ->
                val selectedTeamId = radioGroupTeams.checkedRadioButtonId
                if (selectedTeamId != -1) {
                    val selectedTeam = bettingDialogView.findViewById<RadioButton>(selectedTeamId).text.toString()
                    placeBet(selectedTeam)
                } else {
                    Toast.makeText(this, "Please select a team", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancel", null)
            .create()

        dialog.show()
    }

    private fun placeBet(team: String) {
        Toast.makeText(this, "Bet placed on $team!", Toast.LENGTH_SHORT).show()

        if (!isFirstBetPlaced) {
            unlockFirstBetAchievement()
            isFirstBetPlaced = true
        }
    }

    private fun unlockFirstBetAchievement() {
        val firstBetAchievement = achievements.find { it.title == "First Bet Placed" }
        firstBetAchievement?.isLocked = false
        adapter.notifyDataSetChanged()

        showAchievementUnlockedDialog()
    }

    private fun showAchievementUnlockedDialog() {
        val inflater = LayoutInflater.from(this)
        val dialogView = inflater.inflate(R.layout.dialogue_achievement_unlocked, null)

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        val btnDone = dialogView.findViewById<Button>(R.id.btnDone)
        btnDone.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}
