package ssalim.example.capstone_info6134

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_HIGH
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class ReminderReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context,
                           intent: Intent) {
        val sChannelId =
            "BallLife"
        createNotificationChannel(
            context,
            sChannelId
        )

        val builder =
            NotificationCompat.Builder(
                context,
                sChannelId
            )
            .setSmallIcon(
                R.drawable.balllife
            )

            .setContentTitle(
                "Team Score Reminder"
            )

            .setContentText(
                "Check the team score!"
            )
            .setPriority(
                NotificationCompat.PRIORITY_HIGH
            )

            .setAutoCancel(
                true
            )

        with(NotificationManagerCompat.from(context)) {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            notify(1, builder.build())
        }
    }

    private fun createNotificationChannel(context: Context, channelId: String) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val sName =
                "BallLife"
            val sDescription =
                "Channel for team score reminders"
            val sPriority =
                IMPORTANCE_HIGH
            val sChannel =
                NotificationChannel(
                    channelId,
                    sName,
                    sPriority).apply {
                description =
                    sDescription
            }
            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(sChannel)
        }
    }
}
