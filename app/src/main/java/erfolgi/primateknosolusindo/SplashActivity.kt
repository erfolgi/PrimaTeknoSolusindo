package erfolgi.primateknosolusindo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.AsyncTask
import android.os.Handler
import android.util.Log
import android.view.Window
import android.view.WindowManager
import erfolgi.primateknosolusindo.db.HWHelper
import erfolgi.primateknosolusindo.model.HWModel
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader
import java.util.ArrayList


class SplashActivity : AppCompatActivity() {
    private val TAG = SplashActivity::class.java.simpleName
    private val SPLASH_DISPLAY_LENGTH = 1500
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val actionBar = supportActionBar
        actionBar?.hide()
        Handler().postDelayed(Runnable {
            LoadDataHW().execute()
        }, 1000)//SPLASH_DISPLAY_LENGTH.toLong())

    }
///////////////////////////////////////////////////////////////////////////////////////////////////

    private inner class LoadDataHW : AsyncTask<Void, Int, Void>() {
        internal val TAG = LoadDataHW::class.java.simpleName
        internal lateinit var hwHelper: HWHelper
        internal lateinit var appPreference: AppPreference

        override fun onPreExecute() {

            hwHelper = HWHelper(this@SplashActivity)
            appPreference = AppPreference(this@SplashActivity)
            Log.d("->","OnPreExecute")
        }

        override fun doInBackground(vararg params: Void): Void? {

            val firstRun = appPreference.firstRun
            Log.d("->","1 "+firstRun)
            if (firstRun!!) {

                val HardwareList = preLoadRaw()

                hwHelper.open()
                hwHelper.drop()
                hwHelper.beginTransaction()
                try {
                    for (model in HardwareList) {
                        hwHelper.insertTransaction(model)
                    }
                    hwHelper.setTransactionSuccess()

                } catch (e: Exception) {
                    Log.e(TAG, "doInBackground: Exception")
                }
                hwHelper.endTransaction()
                hwHelper.close()
                appPreference.firstRun=(false)

            } else {

            }
            Log.d("->","return")
            return null
        }


        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            Log.d("->","END")
            val startActivityIntent = Intent(this@SplashActivity, DrawerActivity::class.java)
            startActivity(startActivityIntent)
            finish()

        }

    }

    fun preLoadRaw(): ArrayList<HWModel> {
    Log.d("HW", "PreLoad")
        val HardwareModels = ArrayList<HWModel>()
        var line: String? = null
        val reader: BufferedReader
        try {
            val res = resources
            val raw_dict = res.openRawResource(R.raw.hw)

            reader = BufferedReader(InputStreamReader(raw_dict) as Reader?)
            Log.d("HW", "PreLoad try")
            var count = 0
            do {
                line = reader.readLine()
                val HardModel: HWModel

                HardModel = HWModel(line)
                HardwareModels.add(HardModel)
                count++
                Log.d("HW", "PreLoad while")
            } while (line != null)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("HW", "PreLoad catch")
        }

        return HardwareModels
    }
}
