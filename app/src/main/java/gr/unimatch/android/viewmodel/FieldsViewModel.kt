package gr.unimatch.android.viewmodel

import androidx.lifecycle.LiveData
import gr.unimatch.android.database.entity.Field

interface FieldsViewModel {
    val fields: LiveData<List<Field>>
}
