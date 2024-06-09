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

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }



    fun onCardClick(view: View) {
        when (view.id) {
            R.id.teamDetails -> {
                Toast.makeText(this, "Team Details", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, TeamDetails::class.java)
                startActivity(intent)
            }
            R.id.cardView2 -> {
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
            else -> super.onOptionsItemSelected(item)
        }
    }
}