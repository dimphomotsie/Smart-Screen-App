package com.example.practice_practicum3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    // declare variables
    private lateinit var etDate: EditText
    private  lateinit var etMorning: EditText
    private lateinit var etAfternoon: EditText
    private lateinit var etNotes: EditText
    private lateinit var tvMessage: TextView

    private lateinit var buttonSave : Button
    private lateinit var buttonClear : Button
    private lateinit var buttonNext : Button

    // declare arrays
    private val dateArray = mutableListOf<String>()
    private val timeArrayMorning = mutableListOf<Float>()
    private val timeArrayAfternoon = mutableListOf<Float>()
    private val notesArray = mutableListOf<String>()


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        // Initialize variables

        etDate = findViewById(R.id.etDate)
        etMorning = findViewById(R.id.etMorning)
        etAfternoon = findViewById(R.id.etAfternoon)
        etNotes = findViewById(R.id.etNotes)
        tvMessage = findViewById(R.id.tvMessage)

        buttonSave = findViewById(R.id.buttonSave)
        buttonClear = findViewById(R.id.buttonClear)
        buttonNext = findViewById(R.id.buttonNext)

        // Set click listeners

        buttonClear.setOnClickListener {
            etDate.setText("")
            etMorning.setText("")
            etAfternoon.setText("")
            etNotes.setText("")
        }

        buttonSave.setOnClickListener {
            val screenTimeDate = etDate.text.toString()
            val screenTimeMorning = etMorning.text.toString()
            val screenTimeAfternoon = etAfternoon.text.toString()
            val screenTimeNotes = etNotes.text.toString()

            if (screenTimeDate.isNotEmpty() && screenTimeMorning.isNotEmpty() && screenTimeAfternoon.isNotEmpty()) {
                try {
                    dateArray.add(screenTimeDate)
                    timeArrayMorning.add(screenTimeMorning.toFloat())
                    timeArrayAfternoon.add(screenTimeAfternoon.toFloat())
                    notesArray.add(screenTimeNotes)
                    etDate.text.clear()
                    etMorning.text.clear()
                    etAfternoon.text.clear()
                    etNotes.text.clear()
                } catch (e: NumberFormatException) {
                    tvMessage.text = "Please enter a valid number"

                }

            } else {
                tvMessage.text = "Input cannot be empty"
            }

        }

        buttonNext.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("dateArray", dateArray.toTypedArray())
            intent.putExtra("timeArrayMorning", timeArrayMorning.toFloatArray())
            intent.putExtra("timeArrayAfternoon", timeArrayAfternoon.toFloatArray())
            intent.putExtra("notesArray", notesArray.toTypedArray())
            startActivity(intent)
        }
    }
}