package inft2501.oving6.oving7

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import inft2501.oving6.oving7.data.Movie
import inft2501.oving6.oving7.databinding.MyLayoutBinding
import inft2501.oving6.oving7.managers.FileManager
import inft2501.oving6.oving7.service.Database
import org.json.JSONArray
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var db: Database
    private lateinit var fileManager: FileManager
    private lateinit var myLayout: MyLayoutBinding
    private var backgroundColorId: Int = 0
    private lateinit var movies: MutableList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myLayout = MyLayoutBinding.inflate(layoutInflater)
        setContentView(myLayout.root)
        db = Database(this)
        fileManager = FileManager(this)
        val moviesArray = fileManager.readFromJson()
        db.insertFromJson(moviesArray)
        saveMoviesToObject(moviesArray)
        fileManager.writeToTxt(movies)


        // DETTE FUNKER
        /*try {
            val fileOutputStream: FileOutputStream = openFileOutput("mytextfile.txt", Context.MODE_PRIVATE)
            val outputWriter = OutputStreamWriter(fileOutputStream)
            outputWriter.write("editText.text.toString()")
            outputWriter.close()
            //display file saved message
        }
        catch (e: Exception) {
            e.printStackTrace()
        }*/

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
        myLayout.result.text = res
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.settings, menu)
        menu.add(0, 1, 0, "All Movies")
        menu.add(0, 2, 0, "All Actors")
        menu.add(0, 3, 0, "All Movies And Actors")
        menu.add(0, 4, 0, "Moves by Christopher Nolan")
        menu.add(0, 5, 0, "Forfattere av \"All the Presidents Men\"")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> openActivityForResult()
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
        intent.putExtra("color",backgroundColorId)
        startForResult.launch(intent)
    }
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            println(intent)
            val c = intent?.getIntExtra("color",0)
            if (c != null) {
                backgroundColorId = c+1
            }
            println(c)
            val rainbow: IntArray = resources.getIntArray(R.array.rainbow)
            var lay = findViewById<ConstraintLayout>(R.id.constrainLayout)
            lay.setBackgroundColor(rainbow[c!!+1])
        }
    }
}