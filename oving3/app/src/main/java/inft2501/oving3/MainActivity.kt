package inft2501.oving3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*

class MainActivity : AppCompatActivity() {

    private var friends: MutableCollection<Person> = mutableListOf<Person>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        friends.add(Person("Trygve",Date(1999,4,1)))
        Log.v("yah",friends.first().birthday.toString())
    }
}