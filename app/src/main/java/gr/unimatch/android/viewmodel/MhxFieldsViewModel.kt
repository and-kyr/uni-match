package gr.unimatch.android.viewmodel

import androidx.lifecycle.LiveData
import gr.unimatch.android.database.entity.MhxField

interface MhxFieldsViewModel {
    val mhxFields: LiveData<List<MhxField>>
    val selectedMhxFields: LiveData<Set<MhxField>>
    val collegeIdsBySelectedMhxFields: Set<Int>
    val totalCollegesBySelectedMhxFields: LiveData<Int>

    fun onMhxFieldAdded(field: MhxField)
    fun onMhxFieldRemoved(field: MhxField)

    companion object {
        const val SELECTED_MHX_FIELDS_KEY = "selectedMhxFields"
        val DEFAULT_MHX_FIELDS = setOf<MhxField>()
    }
}
