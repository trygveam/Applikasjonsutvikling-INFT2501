/*
package inft2501.oving6.oving7

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout




class SettingsActivity2 : AppCompatActivity(){

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.settings_layout)
		val c = intent.getIntExtra("color",0)
		changeColorOnScreen(c)
	}

	override fun onCreateOptionsMenu(menu: Menu): Boolean {
		menuInflater.inflate(R.menu.settings2, menu)
		val rainbow: IntArray = resources.getIntArray(R.array.rainbow)
		val names  = resources.getStringArray(R.array.color_names)
		Log.e("tag",names[0])
		for (i in rainbow.indices){
			println(i)
			menu.add(0,i-1,0,names[i])
		}
		return super.onCreateOptionsMenu(menu)
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		changeColorOnScreen(item.itemId+1)
		setResult(RESULT_OK, Intent().putExtra("color",item.itemId))
		return super.onOptionsItemSelected(item)
	}

	private fun changeColorOnScreen(itemId: Int) {
		val rainbow: IntArray = resources.getIntArray(R.array.rainbow)
		var lay = findViewById<ConstraintLayout>(R.id.constrainLayoutSetting)
		lay.setBackgroundColor(rainbow[itemId])
	}

	fun clickBack(view: View?){
		finish()
	}
}
*/
