package gr.unimatch.android

import android.content.Context
import gr.unimatch.android.database.UniversitiesDatabase
import gr.unimatch.android.repository.FieldsRepository

class AppContainer(context: Context) {
    private val database = UniversitiesDatabase.get(context)

    val fieldsRepository by lazy {
        FieldsRepository(database.fieldDao())
    }
}
