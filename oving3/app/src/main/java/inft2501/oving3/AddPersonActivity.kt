package inft2501.oving3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class AddPersonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_person)
    }

    @SuppressLint("NewApi")
    fun onClickAddPerson(v: View?){
        val name: TextView = findViewById(R.id.editTextTextPersonName)
        val birthday : TextView = findViewById(R.id.editTextTextPersonBirthday)

        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val date = LocalDate.parse(birthday.getText().toString(), formatter)

        val p = Person(name.getText().toString(), date)
        Log.v("",p.name)
        Log.v("",p.birthday.toString())
        setResult(RESULT_OK,Intent().putExtra("person",p))
        finish()
    }
}