package inft2501.oving4

import android.content.Context
import android.content.res.TypedArray
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment

class Fragment1 : ListFragment(){
    private var names: Array<String> = arrayOf()
    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         names= resources.getStringArray(R.array.animalnames)
        listAdapter = activity?.let {
            ArrayAdapter(it, android.R.layout.simple_list_item_1,
                android.R.id.text1, names)
        }
    }
    override fun onListItemClick(l: ListView, v: View, position: Int, id:
    Long) {
        super.onListItemClick(l, v, position, id)
        mListener!!.onFragmentInteraction(position)
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(pos: Int?)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = try {
            activity as OnFragmentInteractionListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                "$activity must implement OnFragmentInteractionListener"
            )
        }
    }
    override fun onDetach() {
        super.onDetach()
        mListener = null
    }




}