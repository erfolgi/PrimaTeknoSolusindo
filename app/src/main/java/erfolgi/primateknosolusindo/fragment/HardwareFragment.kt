package erfolgi.primateknosolusindo.fragment


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.ListView
import erfolgi.primateknosolusindo.Adapter.CustomListAdapter
import erfolgi.primateknosolusindo.Adapter.ExpandableListAdapter


import erfolgi.primateknosolusindo.R
import erfolgi.primateknosolusindo.db.HWHelper
import erfolgi.primateknosolusindo.model.HWModel
import java.util.ArrayList
import android.widget.ExpandableListView.OnChildClickListener
import android.widget.ExpandableListView.getPackedPositionChild
import erfolgi.primateknosolusindo.DetailActivity
import erfolgi.primateknosolusindo.DrawerActivity


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HardwareFragment : Fragment() {

    //val konsultan = arrayOf("Pengadaan UPS", "Pengadaan Server", "Pengadaan Sistem Informasi", "Pengadaan Web")
    //var imageArray = arrayOf(R.drawable.box, R.drawable.box, R.drawable.exe,R.drawable.exe)
    lateinit var con: Context

    //internal lateinit var lv: ListView

    var listAdapter: ExpandableListAdapter? = null
    lateinit var expListView: ExpandableListView
    lateinit var listDataHeader: List<String>
    lateinit var listDataChild: HashMap<String, List<HWModel>>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_hardware, null)
        this.con = activity!!.baseContext
        displayListView(view);


        return view
    }

    private fun displayListView(view: View) {
        Log.d("->","view1")
        expListView = view!!.findViewById(R.id.lvExp)
        Log.d("->","view2")

        prepareListData()

        listAdapter = ExpandableListAdapter(con, listDataHeader, listDataChild)

        // setting list adapter
        expListView!!.setAdapter(listAdapter)
        expListView.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            /* You must make use of the View v, find the view by id and extract the text as below*/
            val startActivityIntent = Intent(this.context, DetailActivity::class.java)
            startActivityIntent.putExtra(DetailActivity.EXTRA_BARANG, expListView.expandableListAdapter.getChild(groupPosition, childPosition).toString())

            startActivity(startActivityIntent)


            true  // i missed this
        }
    }

    /*
     * Preparing the list data
     */
    private fun prepareListData() {
        listDataHeader = ArrayList()
        listDataChild = HashMap()

        // Adding child data
        for (x in 65..90) {
            (listDataHeader as ArrayList<String>).add(x.toChar().toString())
        }
//        (listDataHeader as ArrayList<String>).add("Hardware")
//        (listDataHeader as ArrayList<String>).add("Software")
        var x = 'A'
        x += 1.toChar().toInt()

        // Adding child data
        val hwHelper=HWHelper(con)
        hwHelper.open()
        val A = hwHelper.getDataByName("A")
        //A.addAll()
        val B = hwHelper.getDataByName("B")
        val C = hwHelper.getDataByName("C")
        val D = hwHelper.getDataByName("D")
        val E = hwHelper.getDataByName("E")
        val F = hwHelper.getDataByName("F")
        val G = hwHelper.getDataByName("G")
        val H = hwHelper.getDataByName("H")
        val I = hwHelper.getDataByName("I")
        val J = hwHelper.getDataByName("J")
        val K = hwHelper.getDataByName("K")
        val L = hwHelper.getDataByName("L")
        val M = hwHelper.getDataByName("M")
        val N = hwHelper.getDataByName("N")
        val O = hwHelper.getDataByName("O")
        val P = hwHelper.getDataByName("P")
        val Q = hwHelper.getDataByName("Q")
        val R = hwHelper.getDataByName("R")
        val S = hwHelper.getDataByName("S")
        val T = hwHelper.getDataByName("T")
        val U = hwHelper.getDataByName("U")
        val V = hwHelper.getDataByName("V")
        val W = hwHelper.getDataByName("W")
        val X = hwHelper.getDataByName("X")
        val Y = hwHelper.getDataByName("Y")
        val Z = hwHelper.getDataByName("Z")



        listDataChild!![listDataHeader[0]] = A
        listDataChild!![listDataHeader[1]] = B
        listDataChild!![listDataHeader[2]] = C
        listDataChild!![listDataHeader[3]] = D
        listDataChild!![listDataHeader[4]] = E
        listDataChild!![listDataHeader[5]] = F
        listDataChild!![listDataHeader[6]] = G
        listDataChild!![listDataHeader[7]] = H
        listDataChild!![listDataHeader[8]] = I
        listDataChild!![listDataHeader[9]] = J
        listDataChild!![listDataHeader[10]] = K
        listDataChild!![listDataHeader[11]] = L
        listDataChild!![listDataHeader[12]] = M
        listDataChild!![listDataHeader[13]] = N
        listDataChild!![listDataHeader[14]] = O
        listDataChild!![listDataHeader[15]] = P
        listDataChild!![listDataHeader[16]] = Q
        listDataChild!![listDataHeader[17]] = R
        listDataChild!![listDataHeader[18]] = S
        listDataChild!![listDataHeader[19]] = T
        listDataChild!![listDataHeader[20]] = U
        listDataChild!![listDataHeader[21]] = V
        listDataChild!![listDataHeader[22]] = W
        listDataChild!![listDataHeader[23]] = X
        listDataChild!![listDataHeader[24]] = Y
        listDataChild!![listDataHeader[25]] = Z

    }




}
