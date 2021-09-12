package inft2501.oving3

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PersonAdapter(private val context: Context,
                    private val dataSource: ArrayList<Person>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater



    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView = inflater.inflate(R.layout.list_item_recipe, parent, false)
        val titleTextView = rowView.findViewById(R.id.recipe_list_title) as TextView
        val subtitleTextView = rowView.findViewById(R.id.recipe_list_subtitle) as TextView
        val detailTextView = rowView.findViewById(R.id.recipe_list_detail) as TextView
        val person = getItem(position) as Person
        titleTextView.text = person.name
        subtitleTextView.text = person.birthday.toString()
        detailTextView.text = "recipe.label"
        return rowView
    }


}