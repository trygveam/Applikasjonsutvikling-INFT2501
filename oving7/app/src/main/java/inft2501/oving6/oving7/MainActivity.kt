package inft2501.oving6.oving7

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.preference.PreferenceManager
import inft2501.oving6.oving7.data.Movie
import inft2501.oving6.oving7.databinding.MinLayoutBinding
import inft2501.oving6.oving7.managers.FileManager
import inft2501.oving6.oving7.managers.MyPreferenceManager
import inft2501.oving6.oving7.service.Database
import org.json.JSONArray
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var db: Database
    private lateinit var fileManager: FileManager
    private lateinit var minLayout: MinLayoutBinding
    private lateinit var movies: MutableList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        minLayout = MinLayoutBinding.inflate(layoutInflater)
        setContentView(minLayout.root)
        db = Database(this)
        fileManager = FileManager(this)
        val moviesArray = fileManager.readFromJson()
        db.insertFromJson(moviesArray)
        saveMoviesToObject(moviesArray)
        fileManager.writeToTxt(movies)

        val pref = MyPreferenceManager(this)
        pref.updateNightMode()

        val prekk = PreferenceManager.getDefaultSharedPreferences(this).getString("colors",resources.getString(R.string.colors_default_value))
        println("prekk $prekk")
        println("this is the returned string " + pref.getString("colors","kuk"))

    }


    private fun saveMoviesToObject(moviesJSON:JSONArray?){
        movies =  ArrayList()
        if (moviesJSON != null) {
            for (i in 0 until moviesJSON.length()) {
                val userDetail = moviesJSON.getJSONObject(i)
                movies.add(Movie(userDetail.getString("title"),userDetail.getString("director"),userDetail.getString("actor").split(",").toTypedArray()))
            }
        }
    }


    private fun showResults(list: ArrayList<String>) {
        val res = StringBuffer("")
        for (s in list) res.append("$s\n")
        minLayout.result.text = res
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.settings, menu)
        menu.add(0, 1, 0, "All Movies")
        menu.add(0, 2, 0, "All Actors")
        menu.add(0, 3, 0, "All Movies And Actors")
        menu.add(0, 4, 0, "Moves by Christopher Nolan")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> openActivityForResult()//startActivity(Intent("inft2501.oving6.oving7.SettingsActivity"))
            1             -> showResults(db.allMovies)
            2             -> showResults(db.allActors)
            3             -> showResults(db.allMoviesAndActors)
            4             -> showResults(db.getMoviesByDirector)
            else          -> return false
        }
        return super.onOptionsItemSelected(item)
    }


    private fun openActivityForResult(){
        val intent = Intent("inft2501.oving6.oving7.SettingsActivity")
        startForResult.launch(intent)
    }
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            val c = intent?.getStringExtra("colors")
            println(c)
            var lay = findViewById<ConstraintLayout>(R.id.constrainLayout)
            lay.setBackgroundColor(Color.parseColor(c))
        }
    }
}