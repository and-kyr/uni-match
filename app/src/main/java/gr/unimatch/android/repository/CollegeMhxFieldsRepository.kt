package gr.unimatch.android.repository

import gr.unimatch.android.database.dao.CollegeMhxFieldDao

class CollegeMhxFieldsRepository(private val collegeMhxFieldDao: CollegeMhxFieldDao) {
    suspend fun getCollegeIds(mhxFieldIds: Set<Int>) =
        collegeMhxFieldDao.getCollegeIdsByMhxFieldIds(mhxFieldIds)
}
