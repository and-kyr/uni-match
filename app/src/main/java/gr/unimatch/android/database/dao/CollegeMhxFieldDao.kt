package gr.unimatch.android.database.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface CollegeMhxFieldDao {
    @Query("SELECT college_id FROM college_mhx_field WHERE mhx_field_id IN(:mhxFieldIds)")
    suspend fun getCollegeIdsByMhxFieldIds(mhxFieldIds: Set<Int>): List<Int>
}
