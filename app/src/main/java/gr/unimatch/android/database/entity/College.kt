package gr.unimatch.android.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.NO_ACTION
import androidx.room.PrimaryKey

@Entity(
    tableName = "college",
    foreignKeys = [
        ForeignKey(
            entity = City::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("city_id"),
            onDelete = NO_ACTION,
            onUpdate = NO_ACTION,
        ),
    ]
)
data class College(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "mhx_code")
    val mhxCode: Int?,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "university")
    val university: String?,

    @ColumnInfo(name = "city_id")
    val cityId: Int?,

    @ColumnInfo(name = "site")
    val site: String?,

    @ColumnInfo(name = "info")
    val info: String?,
)
