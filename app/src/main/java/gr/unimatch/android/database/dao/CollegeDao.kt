package gr.unimatch.android.database.dao

import androidx.room.Dao
import androidx.room.Query
import gr.unimatch.android.database.entity.College

@Dao
interface CollegeDao {
    @Query("SELECT * FROM college WHERE id == :id")
    suspend fun getCollegeById(id: Int): College?

    @Query("SELECT * FROM college WHERE id IN (:collegeIds)")
    suspend fun getColleges(collegeIds: Set<Int>): List<College>
}
