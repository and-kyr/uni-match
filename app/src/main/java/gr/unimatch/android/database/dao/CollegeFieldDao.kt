package gr.unimatch.android.database.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface CollegeFieldDao {
    @Query("SELECT college_id FROM college_field WHERE field_id IN (:fieldIds) OR :idsSize == 0")
    suspend fun getCollegeIdsByFieldIds(fieldIds: Set<Int>, idsSize: Int): List<Int>
}
