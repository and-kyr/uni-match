package gr.unimatch.android.viewmodel

import androidx.lifecycle.LiveData
import gr.unimatch.android.database.entity.Field

interface FieldsViewModel {
    val fields: LiveData<List<Field>>
    val selectedFields: LiveData<Set<Field>>
    val collegeIdsBySelectedFields: LiveData<Set<Int>>

    fun onFieldAdded(field: Field)
    fun onFieldRemoved(field: Field)

    companion object {
        const val SELECTED_FIELDS_KEY = "selectedFields"
        val DEFAULT_FIELDS = listOf<Field>()
    }
}
