package com.yunis.smartconverter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var resultText: TextView
    private lateinit var input: EditText
    private lateinit var resetButton: Button
    private lateinit var convertButton: Button
    private lateinit var toast1: Toast
    private lateinit var toast2: Toast
    private lateinit var toast3: Toast


    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input = findViewById(R.id.inputType)
        resultText = findViewById(R.id.textView2)
        convertButton = findViewById(R.id.button)
        resetButton = findViewById(R.id.button2)
        toast1 = Toast.makeText(this, "Enter a number in the input field, you entered a string.", Toast.LENGTH_SHORT)
        toast2 = Toast.makeText(this, "Enter a number in the input field.", Toast.LENGTH_SHORT)
        toast3 = Toast.makeText(this, "Input field already empty.", Toast.LENGTH_SHORT)


        val conversion = resources.getStringArray(R.array.Conversions)

        // access the spinner
        val spinner = findViewById<Spinner>(R.id.listItems)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                    android.R.layout.simple_spinner_item, conversion)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {

                    when (parent.selectedItem) {
                        parent.getItemAtPosition(0) -> {

                            convertButton.setOnClickListener {
                                convertFahrenheitToCelsius()
                            }
                            reset()
                        }
                        parent.getItemAtPosition(1) -> {

                            convertButton.setOnClickListener {
                                convertCelsiusToFahrenheit()
                            }
                            reset()
                        }
                        parent.getItemAtPosition(2) -> {
                            convertButton.setOnClickListener {
                                convertUsDollarsToEuros()
                            }
                            reset()
                        }
                        parent.getItemAtPosition(3) -> {
                            convertButton.setOnClickListener {
                                convertEurosToUsDollars()
                            }
                            reset()
                        }
                        parent.getItemAtPosition(4) -> {
                            convertButton.setOnClickListener {
                                convertPoundsToKilograms()
                            }
                            reset()
                        }
                        parent.getItemAtPosition(5) -> {
                            convertButton.setOnClickListener {
                                convertKilogramsToPounds()
                            }
                            reset()
                        }
                    }


                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }

    fun convertFahrenheitToCelsius() {
        try {
            if (input.text.toString().isEmpty()) {
                toast2.show()
            } else {
                val celsiusResult: Float = (input.text.toString().toFloat() - 32) * 5 / 9

                resultText.text = celsiusResult.toString()
            }
        } catch (NumberFormatException: Exception) {
            toast1.show()

        }

    }

    fun convertCelsiusToFahrenheit() {
        try {
            if (input.text.toString().isEmpty()) {
                toast2.show()
            } else {
                val fahrenheitResult: Float = (input.text.toString().toFloat() * 9 / 5) + 32
                resultText.text = fahrenheitResult.toString()
            }
        } catch (NumberFormatException: Exception) {
            toast1.show()

        }

    }

    fun convertPoundsToKilograms() {
        try {
            if (input.text.toString().isEmpty()) {
                toast2.show()
            } else {
                val eurosResult: Double = (input.text.toString().toDouble() / 2.2046)
                resultText.text = eurosResult.toString()
            }
        } catch (NumberFormatException: Exception) {
            toast1.show()
        }
    }

    fun convertKilogramsToPounds() {
        try {
            if (input.text.toString().isEmpty()) {
                toast2.show()
            } else {
                val eurosResult: Double = (input.text.toString().toDouble() * 2.2046)
                resultText.text = eurosResult.toString()
            }
        } catch (NumberFormatException: Exception) {
            toast1.show()

        }
    }

    fun convertEurosToUsDollars() {
        try {
            if (input.text.toString().isEmpty()) {
                toast2.show()
            } else {
                val eurosResult: Double = (input.text.toString().toDouble() / 0.823445)
                resultText.text = eurosResult.toString()
            }

        } catch (NumberFormatException: Exception) {
            toast1.show()

        }
    }

    fun convertUsDollarsToEuros() {
        try {
            if (input.text.toString().isEmpty()) {
                toast2.show()
            } else {
                val eurosResult: Double = (input.text.toString().toDouble() * 0.823445)
                resultText.text = eurosResult.toString()
            }
        } catch (NumberFormatException: Exception) {
            toast1.show()
        }
    }

    fun reset() {
        resetButton.setOnClickListener {
            if (input.text.toString().isEmpty()) {
                toast3.show()
            } else {
                input.setText("")
                resultText.text = ""
            }
        }
    }
}



