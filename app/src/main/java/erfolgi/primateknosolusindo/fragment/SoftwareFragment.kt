package erfolgi.primateknosolusindo.fragment


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import erfolgi.primateknosolusindo.Adapter.CustomListAdapter

import erfolgi.primateknosolusindo.R

//import javax.swing.UIManager.put



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SoftwareFragment : Fragment() {
    val software = arrayOf("Antivirus","Office Software","Operating System","Jasa Pembuatan Aplikasi/Software")
    //val detail = arrayOf("Mengaudit IT", "Mengukur tingkat kematangan IT", "Memanajemen Proyek IT")
    var imageArray = arrayOf(R.drawable.exe, R.drawable.exe, R.drawable.exe, R.drawable.exe)

    lateinit var con: Context
    internal lateinit var lv: ListView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_software, null)
        this.con = activity!!.baseContext
        //  var bla = activity!!.
        displayListView(view)
        return view
    }

    private fun displayListView(view: View) {

        lv = view.findViewById(R.id.listSoftware) as ListView
        val whatever =  CustomListAdapter(con, software, imageArray)

        lv.adapter = whatever;



    }

}



