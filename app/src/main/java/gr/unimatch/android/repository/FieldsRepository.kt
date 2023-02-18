package gr.unimatch.android.repository

import gr.unimatch.android.database.dao.FieldDao

class FieldsRepository(private val fieldDao: FieldDao) {
    fun getFields() = fieldDao.getAll()
}
