package erfolgi.primateknosolusindo

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_drawer.*
import kotlinx.android.synthetic.main.app_bar_drawer.*
import android.support.v4.widget.DrawerLayout
import android.widget.TextView
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.Toolbar
import android.view.View
import erfolgi.primateknosolusindo.fragment.About
import erfolgi.primateknosolusindo.fragment.HomeFragment
import erfolgi.primateknosolusindo.fragment.TabFragment


class DrawerActivity : AppCompatActivity() {

    private val TAG = DrawerActivity::class.java!!.getSimpleName()
    private var fragmentManager: FragmentManager? = null
    private var fragment: Fragment? = null
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        title = "Beranda"

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()
        fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragment = HomeFragment()
        fragmentTransaction.replace(R.id.main_container_wrapper, fragment)
        fragmentTransaction.commit()



        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setCheckedItem(R.id.nav_home)
        val header = navigationView.inflateHeaderView(R.layout.nav_header_drawer)
        val profileName = header.findViewById(R.id.profile_name) as TextView
        profileName.text = "Prima Tekno Solusindo"
        navigationView.setNavigationItemSelectedListener { item ->
            val id = item.itemId
            title = "Pilih Menu"
            if (id == R.id.nav_home) {
                title = "Beranda"
                fragment = HomeFragment()

            } else if (id == R.id.nav_services) {
                title = "Layanan"
                fragment =TabFragment()
            }else if (id == R.id.nav_about) {
                title = "Tentang kami"
                fragment =About()
            }else if (id == R.id.email) {
                val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "firzaprima@gmail.com", null))
                //emailIntent.putExtra(Intent.EXTRA_SUBJECT, "")
                startActivity(emailIntent)
            }else if (id == R.id.whatsapp) {
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=6285230123666"))
                startActivity(i)

            }
//            else if (id == R.id.nav_playlist) {
//            } else if (id == R.id.nav_sound_cound) {
//            } else if (id == R.id.nav_raw_folder) {
//            }
            val transaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.main_container_wrapper, fragment)
            transaction.commit()
            val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
            drawer.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.drawer, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }
}
