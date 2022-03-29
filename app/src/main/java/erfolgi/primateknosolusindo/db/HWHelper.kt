package erfolgi.primateknosolusindo.db

import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns._ID
import android.util.Log
import erfolgi.primateknosolusindo.db.DatabaseContract.EngColumns.Companion.NAMA
import erfolgi.primateknosolusindo.db.DatabaseContract.TABLE_HW
import erfolgi.primateknosolusindo.fragment.HardwareFragment
import erfolgi.primateknosolusindo.model.HWModel
import java.util.ArrayList

class HWHelper(private var context: Context) {
    private var dataBaseHelper: DBhelper? = null

    private var database: SQLiteDatabase? = null



    @Throws(SQLException::class)
    fun open(): HWHelper {
        dataBaseHelper = DBhelper(context)
        database = dataBaseHelper!!.writableDatabase
        return this
    }

    fun close() {
        dataBaseHelper!!.close()
    }

    fun getDataByName(kata: String): ArrayList<HWModel> {
        val result = ""
        val cursor = database!!.query(TABLE_HW, null, NAMA + " LIKE ?", arrayOf("$kata%"), null, null, _ID + " ASC", null)
        cursor.moveToFirst()
        val arrayList = ArrayList<HWModel>()
        var hwModel: HWModel
        if (cursor.count > 0) {
            do {
                hwModel = HWModel()
                hwModel.id_hw=(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)))
                hwModel.nama_hw=(cursor.getString(cursor.getColumnIndexOrThrow(NAMA)))
                arrayList.add(hwModel)
                cursor.moveToNext()
            } while (!cursor.isAfterLast)
        }
        cursor.close()
        Log.d("->>", arrayList.toString())
        return arrayList
    }

    fun drop() {
        database!!.delete(TABLE_HW, null, null)
    }

    fun getAllData(): ArrayList<HWModel> {
        val cursor = database!!.query(TABLE_HW, null, null, null, null, null, _ID + " ASC", null)
        cursor.moveToFirst()
        val arrayList = ArrayList<HWModel>()
        var hwModel: HWModel
        if (cursor.count > 0) {
            Log.d("Debug HW", "Count: " + cursor.count)
            do {
                hwModel = HWModel()
                hwModel.id_hw=(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)))
                hwModel.nama_hw=(cursor.getString(cursor.getColumnIndexOrThrow(NAMA)))



                arrayList.add(hwModel)
                cursor.moveToNext()


            } while (cursor.position <= 50 && !cursor.isAfterLast)
        }
        cursor.close()
        return arrayList
    }

    fun insertTransaction(hwModel: HWModel) {
        val sql = ("INSERT INTO " + TABLE_HW + " (" + NAMA
                + ") VALUES (?)")
        val stmt = database!!.compileStatement(sql)
        stmt.bindString(1, hwModel.nama_hw)
        stmt.execute()
        stmt.clearBindings()

    }

    fun beginTransaction() {
        database!!.beginTransaction()
    }

    fun setTransactionSuccess() {
        database!!.setTransactionSuccessful()
    }

    fun endTransaction() {
        database!!.endTransaction()
    }
}