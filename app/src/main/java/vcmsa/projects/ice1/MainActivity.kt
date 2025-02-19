package vcmsa.projects.ice1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var buttonAdd: Button
    private lateinit var buttonSubtract: Button
    private lateinit var buttonMultiply: Button
    private lateinit var buttonDivide: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Or your layout file name

        // Initialize views using findViewById or view binding (recommended)
        editTextNumber1 = findViewById(R.id.editTextNumber1)
        editTextNumber2 = findViewById(R.id.editTextNumber2)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonSubtract = findViewById(R.id.buttonSubtract)
        buttonMultiply = findViewById(R.id.buttonMultiply)
        buttonDivide = findViewById(R.id.buttonDivide)
        textViewResult = findViewById(R.id.textViewResult)

        buttonAdd.setOnClickListener { calculate('+') }
        buttonSubtract.setOnClickListener { calculate('-') }
        buttonMultiply.setOnClickListener { calculate('*') }
        buttonDivide.setOnClickListener { calculate('/') }
    }

    private fun calculate(operator: Char) {
        val num1Str = editTextNumber1.text.toString()
        val num2Str = editTextNumber2.text.toString()

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val num1 = num1Str.toDouble()
            val num2 = num2Str.toDouble()
            var result = 0.0

            when (operator) {
                '+' -> result = num1 + num2
                '-' -> result = num1 - num2
                '*' -> result = num1 * num2
                '/' -> {
                    if (num2 == 0.0) {
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                        return
                    }
                    result = num1 / num2
                }
            }

            textViewResult.text = "Result: $result"

        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Invalid input. Please enter numbers.", Toast.LENGTH_SHORT).show()
        }
    }
}
