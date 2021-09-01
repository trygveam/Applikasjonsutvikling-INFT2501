package inft2501.oving2

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private val requestNumber: Int = 1
    private var value: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startCreateNumberActivity()
    }

    fun startCreateNumberActivity() {
        val intent = Intent("inft2501.CreateNumberActivity")
        intent.putExtra("number",100)
        startActivityForResult(intent,value)
    }

     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_OK) {
            Log.e("onActivityResult()", "Noe gikk galt")
            return
        }
        if (data != null) {
            value = data.getIntExtra("number", value)
            //createToast(value)
            displayNumberToTextview(value)
        }
     }

    private fun createToast(randomNumber:Int){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("AlertDialog")
        builder.setMessage(randomNumber.toString())
        builder.setPositiveButton("OK") { dialog: DialogInterface, which: Int ->
            Toast.makeText(applicationContext, "OK", Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }

    private fun displayNumberToTextview(randomNumber: Int){
        val textView: TextView = findViewById<TextView>(R.id.textview_number)
            textView.text = randomNumber.toString()
    }
}