package gr.unimatch.android.repository

import gr.unimatch.android.database.dao.CollegeMhxFieldDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CollegeMhxFieldsRepository(private val collegeMhxFieldDao: CollegeMhxFieldDao) {
    suspend fun getCollegeIds(mhxFieldIds: Set<Int>) = withContext(Dispatchers.IO) {
        collegeMhxFieldDao.getCollegeIdsByMhxFieldIds(mhxFieldIds, mhxFieldIds.size)
    }
}
