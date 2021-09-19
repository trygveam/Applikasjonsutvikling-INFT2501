package inft2501.oving4

import android.content.res.TypedArray
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import java.nio.file.Files.find

class Fragment2 : Fragment() {

    private var pictures: TypedArray? = null
    private var descriptions: Array<String> = arrayOf()
    private var imageIDs: IntArray = intArrayOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        descriptions  = resources.getStringArray(R.array.animaldescriptions)
        pictures = resources.obtainTypedArray(R.array.pictures)
        imageIDs = IntArray(pictures!!.length())
        for (i in 0 until pictures!!.length()) imageIDs[i] = pictures!!.peekValue(i).resourceId
        return inflater.inflate(R.layout.fragment2, container, false);
    }

    fun setText(pos: Int?) {
        requireView().findViewById<TextView>(R.id.textView).text = descriptions[pos!!]
        requireView().findViewById<ImageView>(R.id.imageView).setImageResource(imageIDs[pos!!])
    }

    public fun displayResult(position : Int){
        requireView().findViewById<TextView>(R.id.textView).text = descriptions.get(position)
        requireView().findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.animal2)


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





    **/
