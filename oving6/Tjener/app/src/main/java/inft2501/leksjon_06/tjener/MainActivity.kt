package inft2501.leksjon_06.tjener

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		val textView = findViewById<TextView>(R.id.textView)
		Server2(textView).start()
	}
}
