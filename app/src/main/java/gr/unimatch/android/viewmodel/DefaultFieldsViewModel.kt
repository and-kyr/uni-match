package gr.unimatch.android.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import gr.unimatch.android.common.createViewModelFactory
import gr.unimatch.android.repository.CollegeFieldsRepository
import gr.unimatch.android.repository.FieldsRepository

class DefaultFieldsViewModel(
    private val savedState: SavedStateHandle,
    private val fieldsRepository: FieldsRepository,
    private val collegeFieldsRepository: CollegeFieldsRepository,
) : ViewModel(), FieldsViewModel {
    override val fields = fieldsRepository.getFields()

    companion object {
        val Factory: ViewModelProvider.Factory =
            createViewModelFactory { savedStateHandle, appContainer ->
                DefaultFieldsViewModel(
                    savedState = savedStateHandle,
                    fieldsRepository = appContainer.fieldsRepository,
                    collegeFieldsRepository = appContainer.collegeFieldsRepository,
                )
            }
    }
}
