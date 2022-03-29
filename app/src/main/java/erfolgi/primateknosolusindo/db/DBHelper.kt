package erfolgi.primateknosolusindo.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns._ID
import erfolgi.primateknosolusindo.db.DatabaseContract.EngColumns.Companion.NAMA
import erfolgi.primateknosolusindo.db.DatabaseContract.TABLE_HW

class DBhelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_HW)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_HW")
        onCreate(db)
    }

    @Synchronized
    override fun close() {
        super.close()
    }

    companion object {

        private val DATABASE_NAME = "dbcv"

        private val DATABASE_VERSION = 1

        var CREATE_TABLE_HW = "create table " + TABLE_HW +
                " (" + _ID + " integer primary key autoincrement, " +
                NAMA + " text not null);"
    }
}
