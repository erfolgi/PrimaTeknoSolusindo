package erfolgi.primateknosolusindo

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class AppPreference(internal var context: Context) {
    internal var prefs: SharedPreferences
    var firstRun: Boolean?
        get() {
            val key = context.resources.getString(R.string.app_first_run)
            return prefs.getBoolean(key, true)
        }
        set(input) {
            val editor = prefs.edit()
            val key = context.resources.getString(R.string.app_first_run)
            editor.putBoolean(key, input!!)
            editor.apply()
        }

    init {
        prefs = PreferenceManager.getDefaultSharedPreferences(context)
    }
}