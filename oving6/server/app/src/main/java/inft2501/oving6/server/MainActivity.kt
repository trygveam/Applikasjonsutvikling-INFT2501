package inft2501.oving6.server

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

class MainActivity : AppCompatActivity() {

    private val PORT: Int = 12345
    private lateinit var textView: TextView

    private var connectedClients = mutableListOf<Socket>()
    private var outgoingMessages = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        start()
    }

    private var ui: String? = ""
        set(str) {
            MainScope().launch {
                val message: String = textView.getText().toString()
                textView.text = message + "\n" + str
            }
            field = str
        }


    fun start() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                println("STARTING SERVER")
                ServerSocket(PORT).use { serverSocket: ServerSocket ->
                    println("SERVER SOCKET CONNECTEC, waiting for clients..")
                    while (true) {
                        val clientSocket = serverSocket.accept()
                        ui = "Client connected: $clientSocket"
                        clientHandler(clientSocket)
                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()
                ui = e.message
            }
        }
    }


    private suspend fun clientHandler(clientSocket: Socket) =
        coroutineScope { // this: CoroutineScope
            CoroutineScope(Dispatchers.IO).launch {
                connectedClients.add(clientSocket)
                sendToClient(clientSocket, "Welcome to the chat Program!")
                readFromClient(clientSocket)
            }
        }


    private suspend fun readFromClient(socket: Socket) = coroutineScope {
        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                val reader = BufferedReader(InputStreamReader(socket.getInputStream()))
                val message = reader.readLine()

                if (message == null) {
                    ui = "Client disconnected"
                    connectedClients.remove(socket)
                    socket.close()
                    break
                } else {
                    connectedClients.filter { it !== socket }.forEach { sendToClient(it, message) }
                    println("Client says: $message")
                }
            }
        }
    }

    private suspend fun sendToClient(socket: Socket, message: String) = coroutineScope {
        CoroutineScope(Dispatchers.IO).launch {
            val writer = PrintWriter(socket.getOutputStream(), true)
            writer.println(message)
            println("Sent following to clients: $message")
        }
    }


}