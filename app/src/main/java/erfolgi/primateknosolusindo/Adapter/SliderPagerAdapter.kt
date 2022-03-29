package erfolgi.primateknosolusindo.Adapter

import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import erfolgi.primateknosolusindo.fragment.ConsultantFragment
import erfolgi.primateknosolusindo.fragment.Slider.Slider1
import erfolgi.primateknosolusindo.fragment.Slider.Slider2
import erfolgi.primateknosolusindo.fragment.Slider.Slider3
import erfolgi.primateknosolusindo.fragment.SoftwareFragment

class SliderPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> {
                return Slider1()
            }
            1 -> {
                return Slider2()
            }
            2 -> {
                return Slider3()
            }
        }
        return null
    }

    override fun getCount(): Int {
        return FRAGMENT_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Slider 1"
            1 -> return "Slider 2"
            2 -> return "Slider 3"
        }
        return null
    }

    companion object {
        private val TAG = CustomFragmentPageAdapter::class.java.simpleName
        private val FRAGMENT_COUNT = 3
    }
}