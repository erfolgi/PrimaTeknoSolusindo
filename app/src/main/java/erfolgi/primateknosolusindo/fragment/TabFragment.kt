package erfolgi.primateknosolusindo.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import erfolgi.primateknosolusindo.R
import android.support.v4.view.ViewPager
import android.support.design.widget.TabLayout
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import erfolgi.primateknosolusindo.Adapter.CustomFragmentPageAdapter


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class TabFragment : Fragment() {

    private val TAG = TabFragment::class.java!!.simpleName
    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null
    fun LibraryFragment() = Unit
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_tab, container, false)
        tabLayout = view.findViewById(R.id.tabs)
        viewPager = view.findViewById(R.id.view_pager)
        viewPager!!.adapter = CustomFragmentPageAdapter(childFragmentManager)
        tabLayout!!.setupWithViewPager(viewPager)
        return view
    }

}
