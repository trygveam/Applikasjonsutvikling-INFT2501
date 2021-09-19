package inft2501.oving4

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.ListFragment

class Fragment2 : ListFragment() {

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
        descriptions = resources.getStringArray(R.array.animaldescriptions)
        listAdapter = activity?.let {
            ArrayAdapter(it, android.R.layout.simple_list_item_1,
                descriptions
            )
        }}




    public fun displayResult(position : Int){
        Log.e("tag",position.toString())
    }
    **/
