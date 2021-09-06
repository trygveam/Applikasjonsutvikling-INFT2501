package inft2501.oving2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class CreateNumberActivity : AppCompatActivity() {

    private var requestNumber: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestNumber = intent.getIntExtra("number",requestNumber)
        makeRandomNumber(requestNumber)
    }

    private fun makeRandomNumber(upperLimit : Int){
        val value = (0..upperLimit).random()
        setResult(RESULT_OK, Intent().putExtra("number",value))
        finish()
    }

}