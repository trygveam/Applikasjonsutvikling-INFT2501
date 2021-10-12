package inft2501.oving6.client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket
import java.net.URISyntaxException

class MainActivity : AppCompatActivity() {

     lateinit var button: Button
     lateinit var client: Client
     lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById<TextView>(R.id.textView)
        button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editTextMessage)
        client = Client(textView,button,editText)
        client.start()

    }

    public fun program() {
        CoroutineScope(Dispatchers.IO).launch {
            ui = " P: Kobler til tjener..."
            try {
                Socket("10.0.2.2", 12345).use { socket: Socket ->
                    ui = "P: Koblet til tjener:\n$socket"
                    delay(5000)
                    readFromServer(socket)
                    delay(5000)
                    sendToServer(socket, "Heisann Tjener! Hyggelig å hilse på deg")
                    button.setOnClickListener{
                        Log.e("tag","diaplyed before sent to server")
                        sendToServer(socket,"simple message")
                    }

                }
            } catch (e: IOException) {
                e.printStackTrace()
                ui = e.message
            }
        }
    }

    private fun readFromServer(socket: Socket) {
        val reader = BufferedReader(InputStreamReader(socket.getInputStream()))
        val message = reader.readLine()
        if (message != null) {
            if(message.isNotBlank()){
                ui = "M: $message"
            }
        }
    }

    private fun sendToServer(socket: Socket, message: String) {
        val writer = PrintWriter(socket.getOutputStream(), true)
        writer.println(message)
        ui = "S: $message"
    }

    private var ui: String? = ""
        set(str) {
            MainScope().launch {
                val message: String = textView.getText().toString()
                textView.text = message + "\n" + str
            }
            field = str
        }
}