package gr.unimatch.android.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = "college_field",
    foreignKeys = [
        ForeignKey(
            entity = College::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("college_id"),
            onDelete = ForeignKey.NO_ACTION,
            onUpdate = ForeignKey.NO_ACTION,
        ),
        ForeignKey(
            entity = Field::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("field_id"),
            onDelete = ForeignKey.NO_ACTION,
            onUpdate = ForeignKey.NO_ACTION,
        ),
    ]
)
@Parcelize
data class CollegeField(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "college_id")
    val collegeId: Int?,

    @ColumnInfo(name = "field_id")
    val fieldId: Int?,
) : Parcelable
