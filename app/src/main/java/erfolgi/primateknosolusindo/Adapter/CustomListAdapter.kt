package erfolgi.primateknosolusindo.Adapter

import android.R.attr.label
import android.content.Context
import android.widget.TextView
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import erfolgi.primateknosolusindo.R
import android.app.Activity


class CustomListAdapter(context: Context, nameArrayParam: Array<String>, imageIDArrayParam: Array<Int>) : ArrayAdapter<String>(context, R.layout.item_custom_listview, nameArrayParam) {


  //  private var context: Activity? = context
  private val mInflater: LayoutInflater? = LayoutInflater.from(context)
    //to store the animal images
    private var imageIDarray: Array<Int>? = imageIDArrayParam

    //to store the list of countries
    private var nameArray: Array<String>? = nameArrayParam

    //to store the list of countries


    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val rowView = mInflater!!.inflate(R.layout.item_custom_listview, null, true)
        val nameTextField = rowView.findViewById(R.id.nama) as TextView
        val imageView = rowView.findViewById(R.id.img_menu) as ImageView
        nameTextField.text = nameArray!![position]
        imageView.setImageResource(imageIDarray!![position])
        return rowView
    }

    override fun getItem(position: Int): String {

        return super.getItem(position)
    }
}

