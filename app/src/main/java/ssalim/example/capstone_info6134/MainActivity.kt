package ssalim.example.capstone_info6134

import android.content.Intent
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
        val myFavoriteTeam= sharedPreference.getSavedTeam(this)

        if (myFavoriteTeam == null) {
            showYourFavoriteTeamDialog()
        } else {
            Toast.makeText(this, "Your favorite team is: $myFavoriteTeam", Toast.LENGTH_SHORT).show()
        }

    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    private fun showYourFavoriteTeamDialog() {

        val spinner = Spinner(this)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.teams_List,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter


        AlertDialog.Builder(this)
            .setTitle("Pick Your Favorite Team")
            .setView(spinner)
            .setPositiveButton("Go Team!") { dialog, which ->
                val selectedTeam = spinner.selectedItem.toString()
                sharedPreference.saveTeam(this, selectedTeam)
                val intent = Intent(this, favouriteActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "You picked: $selectedTeam", Toast.LENGTH_SHORT).show()

            }
            .setNegativeButton("Maybe Later", null)
            .setCancelable(false)
            .show()
    }



    fun onCardClick(view: View) {
        when (view.id) {
            R.id.teamDetails -> {
                Toast.makeText(this, "Team Details", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, TeamDetails::class.java)
                startActivity(intent)
            }
            R.id.cardView2 -> {
                val intent = Intent(this, TodayActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Card 2 Clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.cardView3 -> {
                Toast.makeText(this, "Card 3 Clicked", Toast.LENGTH_SHORT).show()
            }
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
            R.id.action_fav -> {
                Toast.makeText(this,"Favourite Selected ", Toast.LENGTH_SHORT).show()
                val intent= Intent(this,favouriteActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}