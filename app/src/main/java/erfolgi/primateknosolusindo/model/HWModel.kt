package erfolgi.primateknosolusindo.model

import android.os.Parcel
import android.os.Parcelable

class HWModel : Parcelable {
    var id_hw: Int = 0
    var nama_hw: String? = null

set(value) {field=value}

    constructor() {}
    protected constructor(`in`: Parcel) {
        id_hw = `in`.readInt()
        nama_hw = `in`.readString()
    }

    constructor(nama: String) {
        this.nama_hw = nama
    }


    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id_hw)
        dest.writeString(nama_hw)
    }

    companion object {

        val CREATOR: Parcelable.Creator<HWModel> = object : Parcelable.Creator<HWModel> {
            override fun createFromParcel(`in`: Parcel): HWModel {
                return HWModel(`in`)
            }

            override fun newArray(size: Int): Array<HWModel?> {
                return arrayOfNulls(size)
            }
        }
    }
}
