package inft2501.oving5

import android.os.Bundle
import android.util.Log

import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

const val URL = "https://bigdata.idi.ntnu.no/mobil/tallspill.jsp"

class MainActivity : AppCompatActivity() {

    private val network: HttpWrapper = HttpWrapper(URL)

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonListener()
    }

    private fun buttonListener(){
        val b = findViewById<Button>(R.id.button)
        b.setOnClickListener{
            performRequest(HTTP.GET, requestParameters())
        }

        val bb = findViewById<Button>(R.id.buttonSend)
        bb.setOnClickListener{
            performRequest(HTTP.GET, requestParameterNumber())
        }
    }

    private fun requestParameterNumber():Map<String, String> {
        val number = findViewById<TextView>(R.id.editTextNumber2).text.toString()
        return mapOf(
            "tall" to number
        )
    }

    private fun requestParameters(): Map<String, String> {
        val navn = findViewById<TextView>(R.id.editTextName).text.toString()
        val kortnummer = findViewById<TextView>(R.id.editTextNumber).text.toString()
        return mapOf(
            "navn" to navn,
            "kortnummer" to kortnummer,
        )
    }

    private fun performRequest(typeOfRequest: HTTP, parameterList: Map<String, String>) {
        CoroutineScope(Dispatchers.IO).launch {
            val response: String = try {
                when (typeOfRequest) {
                    HTTP.GET -> network.get(parameterList)
                    HTTP.POST -> network.post(parameterList)
                    HTTP.GET_WITH_HEADER -> network.getWithHeader(parameterList)
                }
            } catch (e: Exception) {
                Log.e("performRequest()", e.message!!)
                e.toString()
            }

            MainScope().launch {
                setResult(response)
            }
        }
    }

    private fun setResult(response: String?) {
        findViewById<TextView>(R.id.result).text = response
    }
}