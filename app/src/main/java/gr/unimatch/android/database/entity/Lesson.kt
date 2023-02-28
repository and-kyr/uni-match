package gr.unimatch.android.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = "lesson",
    foreignKeys = [
        ForeignKey(
            entity = College::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("college_id"),
            onDelete = ForeignKey.NO_ACTION,
            onUpdate = ForeignKey.NO_ACTION,
        ),
    ]
)
@Parcelize
data class Lesson(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "college_id")
    val collegeId: Int?,

    @ColumnInfo(name = "semester_num")
    val semesterNum: Int?,

    @ColumnInfo(name = "semester_season")
    val semesterSeason: String?,
) : Parcelable
