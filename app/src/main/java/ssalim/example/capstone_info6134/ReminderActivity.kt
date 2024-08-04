package ssalim.example.capstone_info6134

import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ReminderActivity : AppCompatActivity() {
    private lateinit var sEditTextDate:
            EditText

    private lateinit var sAlarmManager:
            AlarmManager
    private val sCalendar:
            Calendar = Calendar.getInstance()

    private lateinit var sEditTextTime:
            EditText
    private lateinit var sTextViewReminder:
            TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reminder)

        sTextViewReminder =
            findViewById(R.id.textViewReminderDateTime)
        val setReminderButton: Button =
            findViewById(R.id.buttonSetReminder)

        sAlarmManager =
            getSystemService(ALARM_SERVICE) as AlarmManager

        sEditTextDate =
            findViewById(R.id.editTextDate)
        sEditTextTime =
            findViewById(R.id.editTextTime)

        sEditTextDate.setOnClickListener {
            sDatePick()
        }


        sEditTextTime.setOnClickListener {
            sTimePick()
        }

        setReminderButton.setOnClickListener {
            setReminder()
        }
    }

    private fun sTimePick() {
        val timePickerDialog =
            TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                sCalendar.set(
                    Calendar.HOUR_OF_DAY, hourOfDay
                )

                sCalendar.set(
                    Calendar.MINUTE, minute
                )
                sUpdateTime()
            },
            sCalendar.get(
                Calendar.HOUR_OF_DAY
            ),
            sCalendar.get(
                Calendar.MINUTE
            ),
            true
        )
        timePickerDialog.show()
    }

    private fun sUpdateDate() {
        val dateFormat =
            "MM/dd/yyyy"
        val sdf =
            SimpleDateFormat(
                dateFormat, Locale.US
            )
        sEditTextDate.setText(
            sdf.format(sCalendar.time)
        )
    }

    private fun setReminder() {
        val intent =
            Intent(this, ReminderReceiver::class.java)
        val pendingIntent =
            PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        sAlarmManager.setExact(
            AlarmManager.RTC_WAKEUP,
            sCalendar.timeInMillis,
            pendingIntent
        )

        sTextViewReminder.text =
            "Reminder set for: ${sCalendar.time}"
    }

    private fun sUpdateTime() {
        val timeFormat = "HH:mm"
        val sdf = SimpleDateFormat(timeFormat, Locale.US)
        sEditTextTime.setText(sdf.format(sCalendar.time))
    }

    private fun sDatePick() {
        val datePickerDialog =
            DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                sCalendar.set(Calendar.YEAR, year)
                sCalendar.set(Calendar.MONTH, month)
                sCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                sUpdateDate()
            },
            sCalendar.get(Calendar.YEAR),
            sCalendar.get(Calendar.MONTH),
            sCalendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

}