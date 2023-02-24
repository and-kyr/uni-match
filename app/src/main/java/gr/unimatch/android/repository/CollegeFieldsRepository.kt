package gr.unimatch.android.repository

import gr.unimatch.android.database.dao.CollegeFieldDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class CollegeFieldsRepository(private val collegeFieldDao: CollegeFieldDao) {
    suspend fun getCollegeIds(fieldIds: Set<Int>) = withContext(Dispatchers.IO) {
        collegeFieldDao.getCollegeIdsByFieldIds(fieldIds, fieldIds.size)
    }
}
