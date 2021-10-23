package inft2501.oving6.client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.coroutines.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class MainActivity : AppCompatActivity() {

    private val SERVER_IP: String = "10.0.2.2"
    private val SERVER_PORT: Int = 12345

    var server: Socket? = null
        private set


    var receivedMessages = mutableListOf<String>()
    var sentMessages = mutableListOf<String>()


    private lateinit var textView: TextView
    private lateinit var editText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editTextMessage)
        start()
    }

    fun start() {
        CoroutineScope(Dispatchers.IO).launch {
            println("Connecting to server..")
            try {
                server = Socket(SERVER_IP, SERVER_PORT)
                println("Connected to server: $server")
                startListeningOnServer()
            } catch (e: IOException) {
                e.printStackTrace()
                ui = e.message
            }
        }
    }

    private fun startListeningOnServer() {
        CoroutineScope(Dispatchers.IO).launch {
            server?.let {
                while (true) {
                    val reader = BufferedReader(InputStreamReader(it.getInputStream()))
                    val message = reader.readLine()
                    if (message !== null) {
                        ui = "R: $message"
                        receivedMessages.add(message)
                    } else {
                        it.close()
                        break
                    }
                }
            }
        }
    }


    private var ui: String? = ""
        set(str) {
            MainScope().launch {
                val message: String = textView.getText().toString()
                textView.text = message + "\n" + str
            }
            field = str
        }

    fun onClickSend(view: View) {
        CoroutineScope(Dispatchers.IO).launch {
            var message = editText.text.toString()
            sendToServer(message)
        }
    }


    private suspend fun sendToServer(message: String) = coroutineScope {
        CoroutineScope(Dispatchers.IO).launch {
            server?.let {
                val writer = PrintWriter(it.getOutputStream(), true)
                writer.println(message)
                sentMessages.add(message)
                ui = "You: $message"
            }
        }
    }
}