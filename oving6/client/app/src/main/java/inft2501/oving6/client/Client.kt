package inft2501.oving6.client


import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.coroutines.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy


class Client(
	private val textView: TextView,
	private val button: Button,
	private val editText: EditText,
	private val SERVER_IP: String = "10.0.2.2",
	private val SERVER_PORT: Int = 12345,

) {
	lateinit var sockete: Socket
	lateinit var writer: PrintWriter
	/*
	 * Egendefinert set() som gjør at vi enkelt kan endre teksten som vises i skjermen til
	 * emulatoren med
	 *
	 * ```
	 * ui = "noe"
	 * ```
	 */
	private var ui: String? = ""
		set(str) {
			MainScope().launch { 
				val message: String = textView.getText().toString()
				textView.text = message + "\n" + str
			}
			field = str
		}



	fun start() {
		val policy = ThreadPolicy.Builder().permitAll().build()
		StrictMode.setThreadPolicy(policy)
		CoroutineScope(Dispatchers.IO).launch {
			ui = " P: Kobler til tjener..."
			try {
				Socket(SERVER_IP, SERVER_PORT).use { socket: Socket ->
					sockete = socket
					ui = "P: Koblet til tjener:\n$socket"
					delay(5000)
					readFromServer(socket)
					delay(5000)
					sendToServer(socket, "Heisann Tjener! Hyggelig å hilse på deg")
					while(true) {
						button.setOnClickListener {
							Log.e("tag", "diaplyed before sent to server")
							writer = PrintWriter(socket.getOutputStream(), true)

							writer.println(editText.text.toString())
							ui = "S: hard message"
						}
					}
				}
			} catch (e: IOException) {
				e.printStackTrace()
				ui = e.message
			}
		}
	}

	private fun startListener() {
			/*NumberHandler.getNumbersEverySecond { number: Int ->
			MainScope().launch {
				Log.e("tag","$number")

			}
		}
*/
			writer.println("hard maessage")
			//readFromServer(socket)
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
}

