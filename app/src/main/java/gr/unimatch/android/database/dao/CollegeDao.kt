package gr.unimatch.android.database.dao

import androidx.room.Dao
import androidx.room.Query
import gr.unimatch.android.database.entity.College

@Dao
interface CollegeDao {
    @Query("SELECT * FROM college WHERE id IN (:collegeIds) OR :idsSize == 0")
    suspend fun getColleges(collegeIds: Set<Int>, idsSize: Int): List<College>
}
