package gr.unimatch.android.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import gr.unimatch.android.common.createViewModelFactory
import gr.unimatch.android.repository.FieldsRepository

class FieldsViewModel(
    private val savedState: SavedStateHandle,
    private val fieldsRepository: FieldsRepository,
) : ViewModel() {
    val fields = fieldsRepository.getFields()

    companion object {
        val Factory: ViewModelProvider.Factory =
            createViewModelFactory { savedStateHandle, appContainer ->
                FieldsViewModel(
                    savedState = savedStateHandle,
                    fieldsRepository = appContainer.fieldsRepository,
                )
            }
    }
}
