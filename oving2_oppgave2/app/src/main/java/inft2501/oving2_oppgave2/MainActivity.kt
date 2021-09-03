package inft2501.oving2_oppgave2

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity() {
    private var value:Int = 1
    private var value2:Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openActivityForResult()
    }

    fun openActivityForResult() {
        val intent = Intent("inft2501.oving2.oppgave2.CreateNumbersActivity")
        intent.putExtra("number",100)
        startForResult.launch(intent)
    }


    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            val textViewOne: TextView = findViewById(R.id.textView_number_one)
            val textViewTwo: TextView = findViewById(R.id.textView_number_two)
            if(intent != null){
                textViewOne.text = intent.getIntExtra("numberOne",value).toString()
                textViewTwo.text = intent.getIntExtra("numberTwo",value2).toString()
            }
        }
    }






    fun onClickAdditionButton(v: View?){
        val textViewOne: TextView = findViewById(R.id.textView_number_one)
        var numberOne: Int = Integer.parseInt(textViewOne.getText().toString())

        val textViewTwo: TextView = findViewById(R.id.textView_number_two)
        var numberTwo: Int = Integer.parseInt(textViewTwo.getText().toString())

        val plainTextAnswer: EditText = findViewById(R.id.plainText_answer)
        var answer: Int = Integer.parseInt(plainTextAnswer.getText().toString())

        val plainTextUpperLimit: EditText = findViewById(R.id.plainText_upperLimit)
        var upperLimit: Int = Integer.parseInt(plainTextUpperLimit.getText().toString())

        val solution: Int = numberOne+numberTwo

        createToast(answer,solution, upperLimit)
    }

    fun onClickMultiButton(v: View?){
        val textViewOne: TextView = findViewById(R.id.textView_number_one)
        var numberOne: Int = Integer.parseInt(textViewOne.getText().toString())

        val textViewTwo: TextView = findViewById(R.id.textView_number_two)
        var numberTwo: Int = Integer.parseInt(textViewTwo.getText().toString())

        val plainTextAnswer: EditText = findViewById(R.id.plainText_answer)
        var answer: Int = Integer.parseInt(plainTextAnswer.getText().toString())

        val plainTextUpperLimit: EditText = findViewById(R.id.plainText_upperLimit)
        var upperLimit: Int = Integer.parseInt(plainTextUpperLimit.getText().toString())

        val solution: Int = numberOne*numberTwo

        createToast(answer,solution,upperLimit)
    }

    private fun createToast(answer:Int,solution:Int,upperLimit:Int){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("AlertDialog")
        if (answer == solution)  builder.setMessage(getString(R.string.riktig)) else builder.setMessage(getString(R.string.feil) + solution)
        builder.setPositiveButton("OK") { dialog: DialogInterface, which: Int ->
            Toast.makeText(applicationContext, "OK", Toast.LENGTH_SHORT).show()
        }
        builder.show()
        openActivityForResult()
    }

}