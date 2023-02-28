package gr.unimatch.android

import android.content.Context
import gr.unimatch.android.database.UniversitiesDatabase
import gr.unimatch.android.repository.*

class AppContainer(context: Context) {
    private val database = UniversitiesDatabase.get(context)

    val collegesRepository by lazy {
        CollegesRepository(database.collegeDao())
    }

    val collegeFieldsRepository by lazy {
        CollegeFieldsRepository(database.collegeFieldDao())
    }

    val collegeMhxFieldsRepository by lazy {
        CollegeMhxFieldsRepository(database.collegeMhxFieldDao())
    }

    val fieldsRepository by lazy {
        FieldsRepository(database.fieldDao())
    }

    val mhxFieldsRepository by lazy {
        MhxFieldsRepository(database.mhxFieldDao())
    }
}
