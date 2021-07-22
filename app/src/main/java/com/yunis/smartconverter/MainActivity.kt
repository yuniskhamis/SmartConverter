package com.yunis.smartconverter

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input = findViewById(R.id.inputType)
        resultText = findViewById(R.id.textView2)
        convertButton = findViewById(R.id.button)
        resetButton = findViewById(R.id.button2)


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
                            resetButton.setOnClickListener {
                                input.setText("")
                                resultText.text = ""
                            }


                        }
                        parent.getItemAtPosition(1) -> {

                            convertButton.setOnClickListener {

                                convertCelsiusToFahrenheit()

                            }
                            resetButton.setOnClickListener {
                                input.setText("")
                                resultText.text = ""
                            }

                        }
                        parent.getItemAtPosition(2) -> {
                            convertButton.setOnClickListener {

                                convertUsDollarsToEuros()

                            }
                            resetButton.setOnClickListener {
                                input.setText("")
                                resultText.text = ""
                            }
                        }
                        parent.getItemAtPosition(3) -> {
                            convertButton.setOnClickListener {

                                convertEurosToUsDollars()

                            }
                            resetButton.setOnClickListener {
                                input.setText("")
                                resultText.text = ""
                            }
                        }
                        parent.getItemAtPosition(4) -> {
                            convertButton.setOnClickListener {

                                convertPoundsToKilograms()

                            }
                            resetButton.setOnClickListener {
                                input.setText("")
                                resultText.text = ""
                            }
                        }
                        parent.getItemAtPosition(5) -> {
                            convertButton.setOnClickListener {


                                convertKilogramsToPounds()

                            }
                            resetButton.setOnClickListener {
                                input.setText("")
                                resultText.text = ""
                            }
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
            val celsiusResult: Float = (input.text.toString().toFloat() - 32) * 5 / 9
            resultText.text = celsiusResult.toString()
        } catch (NumberFormatException: Exception) {
            val toast = Toast.makeText(this, "Enter an Integer date type, you entered a string", Toast.LENGTH_SHORT)
            toast.show()

        }

    }

    fun convertCelsiusToFahrenheit() {
        // if (input.text != null) {
        try {
            val fahrenheitResult: Float = (input.text.toString().toFloat() * 9 / 5) + 32
            resultText.text = fahrenheitResult.toString()
        } catch (NumberFormatException: Exception) {
            val toast = Toast.makeText(this, "Enter an Integer date type, you entered a string", Toast.LENGTH_SHORT)
            toast.show()

        }
        //}
    }

    fun convertPoundsToKilograms() {
        try {
            val eurosResult: Double = (input.text.toString().toDouble() / 2.2046)
            resultText.text = eurosResult.toString()
        } catch (NumberFormatException: Exception) {
            val toast = Toast.makeText(this, "Enter an Integer date type, you entered a string", Toast.LENGTH_SHORT)
            toast.show()

        }

    }

    fun convertKilogramsToPounds() {
        try {
            val eurosResult: Double = (input.text.toString().toDouble() * 2.2046)
            resultText.text = eurosResult.toString()
        } catch (NumberFormatException: Exception) {
            val toast = Toast.makeText(this, "Enter an Integer date type, you entered a string", Toast.LENGTH_SHORT)
            toast.show()

        }
    }

    fun convertEurosToUsDollars() {
        try {
            val eurosResult: Double = (input.text.toString().toDouble() / 0.823445)
            resultText.text = eurosResult.toString()

        } catch (NumberFormatException: Exception) {
            val toast = Toast.makeText(this, "Enter an Integer date type, you entered a string", Toast.LENGTH_SHORT)
            toast.show()

        }
    }

    fun convertUsDollarsToEuros() {
        try {
            val eurosResult: Double = (input.text.toString().toDouble() * 0.823445)
            resultText.text = eurosResult.toString()
        } catch (NumberFormatException: Exception) {
            val toast = Toast.makeText(this, "Enter an Integer date type, you entered a string", Toast.LENGTH_SHORT)
            toast.show()

        }
    }
}



