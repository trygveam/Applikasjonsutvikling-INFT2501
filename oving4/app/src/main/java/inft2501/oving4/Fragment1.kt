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

    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
        Bundle?
    ): View {
        val view: View = inflater.inflate(
            R.layout.fragment1, container,
            false
        )
        view.findViewById<EditText>(R.id.editText).addTextChangedListener(object
            : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int, before:
                Int, count: Int
            ) {
                mListener!!.onFragmentInteraction(s.toString())
            }
        })
        return view
    }*/


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
        Log.e("tag",position.toString())
        mListener!!.onFragmentInteraction(position)
    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
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
    }*/
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