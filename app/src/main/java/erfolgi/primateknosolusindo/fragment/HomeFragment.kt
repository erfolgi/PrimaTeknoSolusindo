package erfolgi.primateknosolusindo.fragment


import android.os.Bundle
import android.os.Handler
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import erfolgi.primateknosolusindo.Adapter.CustomFragmentPageAdapter
import erfolgi.primateknosolusindo.Adapter.SliderPagerAdapter

import erfolgi.primateknosolusindo.R
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {
    val DELAY_MS: Long = 5000//delay in milliseconds before task is to be executed
    val PERIOD_MS: Long = 3000
    var currentPage=0
    var NUM_PAGES=3
    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        viewPager = view.findViewById(R.id.slide_pager)
        viewPager!!.adapter = SliderPagerAdapter(childFragmentManager)

        val handler = Handler()
        val Update = Runnable {
            if (currentPage === NUM_PAGES ) {
                currentPage = 0
            }
            viewPager!!.setCurrentItem(currentPage++, true)
        }

        var timer = Timer()
        timer.schedule(object : TimerTask() {

            override fun run() {
                handler.post(Update)
            }
        }, DELAY_MS, PERIOD_MS)
        return view
    }


}
