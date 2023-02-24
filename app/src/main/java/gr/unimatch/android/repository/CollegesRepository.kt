package gr.unimatch.android.repository

import gr.unimatch.android.database.dao.CollegeDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CollegesRepository(private val collegeDao: CollegeDao) {
    suspend fun getColleges(collegeIds: Set<Int>) = withContext(Dispatchers.IO) {
        collegeDao.getColleges(
            collegeIds = collegeIds,
            idsSize = collegeIds.size,
        )
    }
}
