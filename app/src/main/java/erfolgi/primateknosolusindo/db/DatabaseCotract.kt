package erfolgi.primateknosolusindo.db


import android.provider.BaseColumns

object DatabaseContract {

    var TABLE_HW = "HW_TABLE"

    class EngColumns : BaseColumns {
        companion object {
            var NAMA = "nama"
        }
    }
}
