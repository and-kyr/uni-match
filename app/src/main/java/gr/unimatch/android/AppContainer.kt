package gr.unimatch.android

import android.content.Context
import gr.unimatch.android.database.UniversitiesDatabase
import gr.unimatch.android.repository.CollegeFieldsRepository
import gr.unimatch.android.repository.CollegeMhxFieldsRepository
import gr.unimatch.android.repository.FieldsRepository
import gr.unimatch.android.repository.MhxFieldsRepository

class AppContainer(context: Context) {
    private val database = UniversitiesDatabase.get(context)

    val fieldsRepository by lazy {
        FieldsRepository(database.fieldDao())
    }

    val mhxFieldsRepository by lazy {
        MhxFieldsRepository(database.mhxFieldDao())
    }

    val collegeFieldsRepository by lazy {
        CollegeFieldsRepository(database.collegeFieldDao())
    }

    val collegeMhxFieldsRepository by lazy {
        CollegeMhxFieldsRepository(database.collegeMhxFieldDao())
    }
}
