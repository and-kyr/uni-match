package gr.unimatch.android.viewmodel

import androidx.lifecycle.*
import gr.unimatch.android.common.createViewModelFactory
import gr.unimatch.android.database.entity.MhxField
import gr.unimatch.android.repository.CollegeMhxFieldsRepository
import gr.unimatch.android.repository.MhxFieldsRepository
import gr.unimatch.android.viewmodel.MhxFieldsViewModel.Companion.DEFAULT_MHX_FIELDS
import gr.unimatch.android.viewmodel.MhxFieldsViewModel.Companion.SELECTED_MHX_FIELDS_KEY

class DefaultMhxFieldsViewModel(
    private val savedState: SavedStateHandle,
    private val mhxFieldsRepository: MhxFieldsRepository,
    private val collegeMhxFieldsRepository: CollegeMhxFieldsRepository,
) : ViewModel(), MhxFieldsViewModel {
    override val mhxFields = mhxFieldsRepository.getMhxFields()

    private var selectedMhxFieldsValue: List<MhxField>
        get() = savedState[SELECTED_MHX_FIELDS_KEY] ?: DEFAULT_MHX_FIELDS
        private set(value) {
            savedState[SELECTED_MHX_FIELDS_KEY] = value
        }

    override val selectedMhxFields: LiveData<Set<MhxField>>
        get() = savedState.getLiveData(
            key = SELECTED_MHX_FIELDS_KEY,
            initialValue = DEFAULT_MHX_FIELDS,
        ).map { it.toSet() }.distinctUntilChanged()

    override fun onMhxFieldAdded(field: MhxField) {
        selectedMhxFieldsValue = selectedMhxFieldsValue + field
    }

    override fun onMhxFieldRemoved(field: MhxField) {
        selectedMhxFieldsValue = selectedMhxFieldsValue - field
    }

    override val collegeIdsBySelectedMhxFields: LiveData<Set<Int>> =
        selectedMhxFields.switchMap { mhxFields ->
            liveData {
                emit(getCollegeIds(mhxFields))
            }
        }

    private suspend fun getCollegeIds(selectedMhxFields: Set<MhxField>) =
        collegeMhxFieldsRepository.getCollegeIds(
            mhxFieldIds = selectedMhxFields.map { it.id }.toSet()
        ).toSet()

    companion object {
        val Factory: ViewModelProvider.Factory =
            createViewModelFactory { savedStateHandle, appContainer ->
                DefaultMhxFieldsViewModel(
                    savedState = savedStateHandle,
                    mhxFieldsRepository = appContainer.mhxFieldsRepository,
                    collegeMhxFieldsRepository = appContainer.collegeMhxFieldsRepository,
                )
            }
    }
}
