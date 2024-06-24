package ssalim.example.capstone_info6134

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class TeamAdapter(context: Context, private val teamNames: Array<String>, private val teamLogos: IntArray) :
    ArrayAdapter<String>(context, 0, teamNames) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createViewFromResource(convertView, parent, position)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createViewFromResource(convertView, parent, position)
    }

    private fun createViewFromResource(convertView: View?, parent: ViewGroup, position: Int): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false)
        val teamLogo = view.findViewById<ImageView>(R.id.team_logo)
        val teamName = view.findViewById<TextView>(R.id.team_name)

        teamLogo.setImageResource(teamLogos[position])
        teamName.text = teamNames[position]

        return view
    }
}