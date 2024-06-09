package ssalim.example.capstone_info6134

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFavoriteTeamDialog()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    private fun showFavoriteTeamDialog() {
        // Create a Spinner with a list of teams
        val spinner = Spinner(this)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.teams_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Create an AlertDialog
        AlertDialog.Builder(this)
            .setTitle("Select Your Favorite Team")
            .setView(spinner)
            .setPositiveButton("OK") { dialog, which ->
                val selectedTeam = spinner.selectedItem.toString()
                // Handle the selected team here
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    fun onCardClick(view: View) {
        when (view.id) {
            R.id.cardView -> Toast.makeText(this, "Card 1 Clicked", Toast.LENGTH_SHORT).show()
            R.id.cardView2 -> Toast.makeText(this, "Card 2 Clicked", Toast.LENGTH_SHORT).show()
            R.id.cardView3 -> Toast.makeText(this, "Card 3 Clicked", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_about -> {
                Toast.makeText(this, "About selected", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}