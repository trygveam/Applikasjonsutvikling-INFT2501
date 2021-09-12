package inft2501.oving3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.String.format
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class EditPersonActivity : AppCompatActivity() {

    private lateinit var person :Person


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_person)
        person = intent?.getSerializableExtra("person") as Person
        displayInformation()
    }

    private fun displayInformation(){
        val name: TextView = findViewById(R.id.editTextName)
        val birthday : TextView = findViewById(R.id.editTextBirthday)
        Log.e("before",person.name.toString() + person.birthday.toString())
        name.setText(person.name)
        birthday.setText(person.birthday.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")))
    }

    @SuppressLint("NewApi")
    fun onClickEditPerson(v: View?){
        val name: TextView = findViewById(R.id.editTextName)

        val birthday : TextView = findViewById(R.id.editTextBirthday)

        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val date = LocalDate.parse(birthday.getText().toString(), formatter)

        setResult(RESULT_OK,Intent().putExtra("origPerson",person).putExtra("newPerson",Person(name.toString(),date)))
        finish()
    }

    fun onClickBack(v:View?){
        finish()
    }
}