package com.example.practice_practicum3

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity3 : AppCompatActivity() {

    // declare variables

    private lateinit var textView4: TextView
    private lateinit var textView5: TextView
    private lateinit var textView6: TextView
    private lateinit var textView7: TextView

    private lateinit var buttonBack: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        // initialise variables

        textView4 = findViewById(R.id.textView4)
        textView5 = findViewById(R.id.textView5)
        textView6 = findViewById(R.id.textView6)
        textView7 = findViewById(R.id.textView7)

        buttonBack = findViewById(R.id.buttonBack)

        val dateArray = intent.getStringArrayExtra("dateArray")?.toList()?: emptyList()
        val timeArrayMorning = intent.getStringArrayExtra("timeArrayMorning")?.toList()?: emptyList()
        val timeArrayAfternoon = intent.getStringArrayExtra("timeArrayAfternoon")?.toList()?: emptyList()
        val notesArray = intent.getStringArrayExtra("notesArray")?.toList()?: emptyList()

        val  dated = StringBuilder()
        for ((index, date) in dateArray.withIndex()) {
            dated.append("Date $index: $date \n")
        }

        val hoursAM = StringBuilder()
        for ((index, time) in timeArrayMorning.withIndex()) {
            hoursAM.append("Morning $index: $time \n")
        }

        val hoursPM = StringBuilder()
        for ((index, time) in timeArrayAfternoon.withIndex()) {
            hoursPM.append("Afternoon $index: $time \n")
        }

        val notes = StringBuilder()
        for ((index, note) in notesArray.withIndex()) {
            notes.append("Note $index: $note \n")
        }

        textView4.text = dated.toString()
        textView5.text = hoursAM.toString()
        textView6.text = hoursPM.toString()
        textView7.text = notes.toString()

        // Button to navigate back to the previous screen

        buttonBack.setOnClickListener {
            finish()

        }

    }
}