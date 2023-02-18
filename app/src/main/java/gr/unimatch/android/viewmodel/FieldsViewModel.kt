package gr.unimatch.android.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import gr.unimatch.android.repository.FieldsRepository

class FieldsViewModel(
    private val savedState: SavedStateHandle,
    private val fieldsRepository: FieldsRepository,
) : ViewModel() {
    val fields = fieldsRepository.getFields()

}
