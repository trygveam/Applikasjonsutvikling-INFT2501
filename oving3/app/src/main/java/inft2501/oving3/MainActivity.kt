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
import java.util.*

class MainActivity : AppCompatActivity() {

    private var friends: MutableCollection<Person> = mutableListOf<Person>()
    private var spinnerOptions: Array<String> = arrayOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        spinnerOptions = resources.getStringArray(R.array.spinnerOptions)
        initSpinner()
        initList()
    }

    private fun initSpinner() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerOptions)
        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.adapter = adapter
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
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_activated_1, spinnerOptions)
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = adapter
        listView.choiceMode = ListView.CHOICE_MODE_SINGLE
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
        }
    }

}