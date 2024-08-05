package ssalim.example.capstone_info6134

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class AchievementsAdapter(private val achievements: List<Achievement>) :
    RecyclerView.Adapter<AchievementsAdapter.AchievementViewHolder>() {

    class AchievementViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val description: TextView = itemView.findViewById(R.id.tvDescription)
        val badge: ImageView = itemView.findViewById(R.id.ivBadge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_achievement, parent, false)
        return AchievementViewHolder(view)
    }

    override fun onBindViewHolder(holder: AchievementViewHolder, position: Int) {
        val achievement = achievements[position]
        holder.title.text = achievement.title
        holder.description.text = achievement.description
        holder.badge.setImageResource(achievement.badge)

        if (achievement.isLocked) {
            holder.itemView.alpha = 0.6f
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.locked_border))
        } else {
            holder.itemView.alpha = 1.0f
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.card_background))
        }
    }

    override fun getItemCount(): Int = achievements.size
}
