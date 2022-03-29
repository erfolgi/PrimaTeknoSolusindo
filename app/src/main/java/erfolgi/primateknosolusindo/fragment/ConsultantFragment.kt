package erfolgi.primateknosolusindo.fragment


import android.app.Dialog
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Bundle
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.*

import erfolgi.primateknosolusindo.R
import org.json.JSONException
import org.json.JSONObject
import java.util.ArrayList
import android.R.attr.name
import android.app.Activity
import android.content.Context
import android.content.Intent
//import erfolgi.primateknosolusindo.Adapter.ListAdapter
import android.widget.ArrayAdapter.createFromResource


import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import cn.pedant.SweetAlert.SweetAlertDialog
import erfolgi.primateknosolusindo.Adapter.CustomListAdapter
import erfolgi.primateknosolusindo.DrawerActivity


//import java.rmi.server.UID



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@RequiresApi(Build.VERSION_CODES.HONEYCOMB)
/**
 * A simple [Fragment] subclass.
 *
 */
class ConsultantFragment : Fragment() {

val konsultan = arrayOf("Konsultasi IT", "Audit IT", "Strategic Planning For IS/IT", "Tata Kelola IT")
    val detail = arrayOf("Konsultasi permasalah dan kebutuhan IT dan Teknologi Informasi pada perusahaan",
            "Meninjau dan mengevaluasi faktor-faktor ketersediaan, kerahasiaan dan keutuhan dari sistem informasi organisasi. ",
            "Kebijakan stategis terkait dengan implementasi dan pengembangan Teknologi Informasi/Sistem Informasi pada suatu institusi.",
            "Menyelaraskan IT Resources yang sudah diinvestasikan dengan strategi organisasi ")
    var imageArray = arrayOf(R.drawable.paper, R.drawable.paper, R.drawable.paper, R.drawable.paper)

    lateinit var con: Context

    internal lateinit var lv: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_consultant, null)
    this.con = activity!!.baseContext
  //  var bla = activity!!.
    displayListView(view);



        return view
    }

    private fun displayListView(view: View) {

        lv = view.findViewById(R.id.listConsultant) as ListView
        val whatever =  CustomListAdapter(con, konsultan, imageArray)

        lv.adapter = whatever;

        lv.setOnItemClickListener { _, _, position, _ ->
            // 1
            val Judul = konsultan[position]
            val Isi = detail[position]

            val Gambar = imageArray[position]
            // 2
//
            SweetAlertDialog(
                    activity,
                    SweetAlertDialog.CUSTOM_IMAGE_TYPE
            )
                    .setTitleText(Judul)
                    .setContentText(Isi)
                    .setCustomImage(Gambar)
                    .show()


        }

    }

}
