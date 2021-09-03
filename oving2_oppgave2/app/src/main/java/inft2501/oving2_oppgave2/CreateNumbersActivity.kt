package inft2501.oving2_oppgave2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CreateNumbersActivity : AppCompatActivity() {

    private var requestNumber: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestNumber = intent.getIntExtra("number",requestNumber)
        makeRandomNumber(requestNumber)
    }

    fun makeRandomNumber(upperLimit : Int){
        val value = (1..upperLimit).random()
        val value2 = (1..upperLimit).random()
        setResult(RESULT_OK, Intent().putExtra("numberTwo",value2).putExtra("numberOne",value))
        finish()
    }


}