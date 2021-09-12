package inft2501.oving3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private var friends: MutableCollection<Person> = mutableListOf<Person>()
    private var spinnerOptions: Array<String> = arrayOf()
    private lateinit var listView: ListView
    private lateinit var adapterSpinner: Adapter
    private lateinit var adapterList: PersonAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        friends.add(Person("Rikke halo",LocalDate.parse("01-04-1999", DateTimeFormatter.ofPattern("dd-MM-yyyy"))))
        friends.add(Person("johnny",LocalDate.parse("01-04-1999", DateTimeFormatter.ofPattern("dd-MM-yyyy"))))
        friends.add(Person("bravoo",LocalDate.parse("01-04-1999", DateTimeFormatter.ofPattern("dd-MM-yyyy"))))

        spinnerOptions = resources.getStringArray(R.array.spinnerOptions)
        initSpinner()
        initList()

    }

    private fun initSpinner() {
        adapterSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerOptions)
        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.adapter = adapterSpinner as ArrayAdapter<String>
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                valgt: View,
                posisjon: Int,
                id: Long
            ) {
                if(posisjon !=0){
                    if (posisjon == 1) openActivityForResult() else Log.e("done","done")
                }
            }

            override fun onNothingSelected(arg0: AdapterView<*>?) {}
        }
        }

    private fun initList() {
        listView = findViewById<ListView>(R.id.listView)
        val listItems = arrayOfNulls<String>(friends.size)
        for ((i, item) in friends.withIndex()) {
            listItems[i] = item.name
        }
        adapterList = PersonAdapter(this, friends as ArrayList<Person>)
        listView.adapter = adapterList

    }


    fun openActivityForResult(){
        val intent = Intent("inft2501.oving3.AddPersonActivity")
        startForResult.launch(intent)
    }

    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            val p = intent?.getSerializableExtra("person") as Person
            // val p = intent.extras?.get("person") as Person
            friends.add(p)
            adapterList.notifyDataSetChanged()
        }
    }

}