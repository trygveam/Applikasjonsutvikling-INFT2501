package inft2501.leksjon_06.klient

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		val textView = findViewById<TextView>(R.id.textView)
		val button = findViewById<Button>(R.id.button)
		val editText = findViewById<EditText>(R.id.editTextMessage)
		Client2(textView,button,editText).start()
	}
}
