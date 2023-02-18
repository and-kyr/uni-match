package gr.unimatch.android.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import gr.unimatch.android.UniMatchApplication
import gr.unimatch.android.repository.FieldsRepository

class FieldsViewModel(
    private val savedState: SavedStateHandle,
    private val fieldsRepository: FieldsRepository,
) : ViewModel() {
    val fields = fieldsRepository.getFields()

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras,
            ): T {
                val application =
                    checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                val savedStateHandle = extras.createSavedStateHandle()

                return FieldsViewModel(
                    savedState = savedStateHandle,
                    fieldsRepository = (application as UniMatchApplication).appContainer.fieldsRepository,
                ) as T
            }
        }
    }
}
