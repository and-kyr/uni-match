package gr.unimatch.android.repository

import gr.unimatch.android.database.dao.MhxFieldDao

class MhxFieldsRepository(private val mhxFieldDao: MhxFieldDao) {
    fun getMhxFields() = mhxFieldDao.getAll()
}
