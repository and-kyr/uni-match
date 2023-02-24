package gr.unimatch.android.viewmodel

import androidx.lifecycle.*
import gr.unimatch.android.common.createViewModelFactory
import gr.unimatch.android.database.entity.Field
import gr.unimatch.android.repository.CollegeFieldsRepository
import gr.unimatch.android.repository.FieldsRepository
import gr.unimatch.android.viewmodel.FieldsViewModel.Companion.DEFAULT_FIELDS
import gr.unimatch.android.viewmodel.FieldsViewModel.Companion.SELECTED_FIELDS_KEY

class DefaultFieldsViewModel(
    private val savedState: SavedStateHandle,
    private val fieldsRepository: FieldsRepository,
    private val collegeFieldsRepository: CollegeFieldsRepository,
) : ViewModel(), FieldsViewModel {
    override val fields = fieldsRepository.getFields()

    private var selectedFieldsValue
        get() = savedState[SELECTED_FIELDS_KEY]
            ?: DEFAULT_FIELDS
        set(value) {
            savedState[SELECTED_FIELDS_KEY] = value
        }

    override val selectedFields: LiveData<Set<Field>>
        get() = savedState.getLiveData(
            key = SELECTED_FIELDS_KEY,
            initialValue = DEFAULT_FIELDS,
        ).distinctUntilChanged()

    override fun onFieldAdded(field: Field) {
        selectedFieldsValue = selectedFieldsValue + field
    }

    override fun onFieldRemoved(field: Field) {
        selectedFieldsValue = selectedFieldsValue - field
    }

    override var collegeIdsBySelectedFields: Set<Int> = setOf()
        private set

    override val totalCollegesBySelectedFields: LiveData<Int> =
        selectedFields.switchMap { fields ->
            liveData {
                collegeIdsBySelectedFields = getCollegeIds(fields)
                emit(collegeIdsBySelectedFields.size)
            }
        }

    private suspend fun getCollegeIds(selectedFields: Set<Field>) =
        collegeFieldsRepository.getCollegeIds(
            fieldIds = selectedFields.map { it.id }.toSet()
        ).toSet()

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
