package inft2501.oving6.server

import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.consumesAll
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

class Server(private val textView: TextView, private val PORT: Int = 12345) {

	/**
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


	/*fun setUI(str: String){
		MainScope().launch { textView.text = str }
	}*/


	fun start() {
		CoroutineScope(Dispatchers.IO).launch {

			try {
				ui = "Starter Tjener ..."
				// "innapropriate blocking method call" advarsel betyr at tråden
				// stopper helt opp og ikke går til neste linje før denne fullfører, i dette
				// eksempelet er ikke dette så farlig så vi ignorerer advarselen.
				ServerSocket(PORT).use { serverSocket: ServerSocket ->

					ui = "ServerSocket opprettet, venter på at en klient kobler seg til...."

					serverSocket.accept().use { clientSocket: Socket ->
						Log.e("tag", "connecting while")
						ui = "En Klient koblet seg til:\n$clientSocket"

						//send tekst til klienten
						sendToClient(clientSocket, "Velkommen Klient!")

						// Hent tekst fra klienten
						readFromClient(clientSocket)

						while(true){
								Log.e("tag","running...")
								readFromClient(clientSocket)
								//delay(5000)
								//sendToClient(clientSocket,"Message Received")

							}
							}
					}
			} catch (e: IOException) {
				e.printStackTrace()
				ui = e.message
			}
		}
	}


	private fun readFromClient(socket: Socket) {
		val reader = BufferedReader(InputStreamReader(socket.getInputStream()))
		val message = reader.readLine()
		if (message != null) {
			if(message.isNotBlank()){
				ui = "M: $message"
			}
		}
	}

	private fun sendToClient(socket: Socket, message: String) {
		val writer = PrintWriter(socket.getOutputStream(), true)
		writer.println(message)
		ui = "S: $message"
	}
}
