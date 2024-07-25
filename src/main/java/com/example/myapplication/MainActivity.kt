package com.example.myapplication
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    // Declare variables to hold references to UI elements
    private lateinit var num1EditText: EditText
    private lateinit var num2EditText: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements from the layout
        num1EditText = findViewById(R.id.num1EditText)
        num2EditText = findViewById(R.id.num2EditText)
        resultTextView = findViewById(R.id.resultTextView)

        // Set click listeners for arithmetic operation buttons
        val addButton: ImageButton = findViewById(R.id.addButton)
        addButton.setOnClickListener { performCalculation('+') }

        val subtractButton: ImageButton = findViewById(R.id.subtractButton)
        subtractButton.setOnClickListener { performCalculation('-') }

        val multiplyButton: ImageButton = findViewById(R.id.multiplyButton)
        multiplyButton.setOnClickListener { performCalculation('*') }

        val divideButton: ImageButton = findViewById(R.id.divideButton)
        divideButton.setOnClickListener { performCalculation('/') }
    }

    private fun performCalculation(operator: Char) {
        // Get the values entered in the input fields
        val num1Str = num1EditText.text.toString()
        val num2Str = num2EditText.text.toString()

        // Check if either input field is empty
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            return // Exit the method to prevent calculations with empty inputs
        }

        // Convert the input values to numeric format
        val num1 = num1Str.toDouble()
        val num2 = num2Str.toDouble()
        var result = 0.0

        // Perform the selected calculation based on the operator
        when (operator) {
            '+' -> result = num1 + num2
            '-' -> result = num1 - num2
            '*' -> result = num1 * num2
            '/' -> {
                if (num2 != 0.0) {
                    result = num1 / num2
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                    return // Exit the method if division by zero is attempted
                }
            }
        }

        // Format and display the calculation result
        val df = DecimalFormat("#.##")
        resultTextView.text = "Result: ${df.format(result)}"
    }
}