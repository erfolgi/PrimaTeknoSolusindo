package erfolgi.primateknosolusindo.Adapter

import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentManager
import erfolgi.primateknosolusindo.fragment.ConsultantFragment
import erfolgi.primateknosolusindo.fragment.HardwareFragment
import erfolgi.primateknosolusindo.fragment.SoftwareFragment




class CustomFragmentPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> {
                return ConsultantFragment()
            }
            1 -> {
                return SoftwareFragment()
            }
            2 -> {
                return HardwareFragment()
            }
        }
        return null
    }

    override fun getCount(): Int {
        return FRAGMENT_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Consultant"
            1 -> return "Software Supplier"
            2 -> return "Hardware Supplier"
        }
        return null
    }

    companion object {
        private val TAG = CustomFragmentPageAdapter::class.java.simpleName
        private val FRAGMENT_COUNT = 3
    }
}