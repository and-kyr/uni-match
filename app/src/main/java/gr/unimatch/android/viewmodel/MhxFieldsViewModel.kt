package gr.unimatch.android.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import gr.unimatch.android.repository.MhxFieldsRepository

class MhxFieldsViewModel(
    private val savedState: SavedStateHandle,
    private val mhxFieldsRepository: MhxFieldsRepository,
) : ViewModel() {
    val mhxFields = mhxFieldsRepository.getMhxFields()
}
