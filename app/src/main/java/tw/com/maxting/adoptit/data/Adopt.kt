package tw.com.maxting.adoptit.data


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Adopt(
        @SerialName("animal_id")
        val animalId: Int = 0, // 160183
        @SerialName("animal_subid")
        val animalSubid: String = "", // LAAAG1090516G1
        @SerialName("animal_area_pkid")
        val animalAreaPkid: Int = 0, // 17
        @SerialName("animal_shelter_pkid")
        val animalShelterPkid: Int = 0, // 75
        @SerialName("animal_place")
        val animalPlace: String = "", // 高雄市壽山動物保護教育園區
        @SerialName("animal_kind")
        val animalKind: String = "", // 狗
        @SerialName("animal_sex")
        val animalSex: String = "", // F
        @SerialName("animal_bodytype")
        val animalBodytype: String = "", // MEDIUM
        @SerialName("animal_colour")
        val animalColour: String = "", // 白色
        @SerialName("animal_age")
        val animalAge: String = "", // ADULT
        @SerialName("animal_sterilization")
        val animalSterilization: String = "", // F
        @SerialName("animal_bacterin")
        val animalBacterin: String = "", // F
        @SerialName("animal_foundplace")
        val animalFoundplace: String = "", // 高鳳路
        @SerialName("animal_title")
        val animalTitle: String = "",
        @SerialName("animal_status")
        val animalStatus: String = "", // OPEN
        @SerialName("animal_remark")
        val animalRemark: String = "", // ※協尋飼主中.暫不開放
        @SerialName("animal_caption")
        val animalCaption: String = "",
        @SerialName("animal_opendate")
        val animalOpendate: String = "",
        @SerialName("animal_closeddate")
        val animalCloseddate: String = "", // 2999-12-31
        @SerialName("animal_update")
        val animalUpdate: String = "", // 2020/05/16
        @SerialName("animal_createtime")
        val animalCreatetime: String = "", // 2020/05/16
        @SerialName("shelter_name")
        val shelterName: String = "", // 高雄市壽山動物保護教育園區
        @SerialName("album_file")
        val albumFile: String = "",
        @SerialName("album_update")
        val albumUpdate: String = "",
        @SerialName("cDate")
        val cDate: String = "", // 2020/05/16
        @SerialName("shelter_address")
        val shelterAddress: String = "", // 高雄市鼓山區萬壽路350號
        @SerialName("shelter_tel")
        val shelterTel: String = "" // 07-5519059
) : Parcelable