package gr.unimatch.android.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = "college_mhx_field",
    foreignKeys = [
        ForeignKey(
            entity = College::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("college_id"),
            onDelete = ForeignKey.NO_ACTION,
            onUpdate = ForeignKey.NO_ACTION,
        ),
        ForeignKey(
            entity = MhxField::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("mhx_field_id"),
            onDelete = ForeignKey.NO_ACTION,
            onUpdate = ForeignKey.NO_ACTION,
        ),
    ]
)
@Parcelize
data class CollegeMhxField(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "college_id")
    val collegeId: Int?,

    @ColumnInfo(name = "mhx_field_id")
    val mhxFieldId: Int?,
) : Parcelable
