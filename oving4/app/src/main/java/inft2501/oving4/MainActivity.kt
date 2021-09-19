package inft2501.oving4

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity

class MainActivity : AppCompatActivity(), Fragment1.OnFragmentInteractionListener
{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onFragmentInteraction(pos: Int?) {
        val fragment2 =
            supportFragmentManager.findFragmentById(R.id.fragment2) as
                    Fragment2
        fragment2.setText(pos)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_back -> Log.e("tag","back")
            R.id.menu_next -> Log.e("tag","next")
            R.id.menu_exit -> finish()
            else -> return false
        }
        return true
    }
}