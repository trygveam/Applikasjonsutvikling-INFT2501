package inft2501.oving4

import android.content.res.TypedArray
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

class Fragment1 : ListFragment(){
    private var pictures: TypedArray? = null
    private var descriptions: Array<String> = arrayOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment1, container, false);
    }
}

/**
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        descriptions = resources.getStringArray(R.array.animalnames)
        pictures =  resources.obtainTypedArray(R.array.pictures)
        listAdapter = activity?.let {
            ArrayAdapter(it, android.R.layout.simple_list_item_1,
                android.R.id.text1, descriptions)
        }
    }


    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        val lol = Fragment2()
        lol.displayResult(position)
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(text: String?)
    }

**/