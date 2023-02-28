package gr.unimatch.android.viewmodel

import androidx.lifecycle.*
import gr.unimatch.android.AppContainer
import gr.unimatch.android.common.createViewModelFactory
import gr.unimatch.android.common.intersectMany
import kotlinx.coroutines.flow.combine

class FiltersViewModel(
    private val savedState: SavedStateHandle,
    appContainer: AppContainer,
) : ViewModel(),
    FieldsViewModel by DefaultFieldsViewModel(
        savedState = savedState,
        fieldsRepository = appContainer.fieldsRepository,
        collegeFieldsRepository = appContainer.collegeFieldsRepository,
    ),
    MhxFieldsViewModel by DefaultMhxFieldsViewModel(
        savedState = savedState,
        mhxFieldsRepository = appContainer.mhxFieldsRepository,
        collegeMhxFieldsRepository = appContainer.collegeMhxFieldsRepository,
    ) {
    val collegeIdsResult: Set<Int>
        get() = collegeIdsFromSelectedFilters.value ?: emptySet()

    private val collegeIdsFromSelectedFilters: LiveData<Set<Int>> =
        combineCollegeIds(
            collegeIdsBySelectedFields,
            collegeIdsBySelectedMhxFields,
        )

    private fun combineCollegeIds(
        vararg livedata: LiveData<Set<Int>>
    ): LiveData<Set<Int>> =
        combine(
            livedata.map { it.asFlow() }
        ) {
            intersectMany(*it)
        }.asLiveData()

    val totalCollegesFromSelectedFilters: LiveData<Int> =
        collegeIdsFromSelectedFilters.map { it.size }

    companion object {
        val Factory: ViewModelProvider.Factory =
            createViewModelFactory { savedStateHandle, appContainer ->
                FiltersViewModel(
                    savedState = savedStateHandle,
                    appContainer = appContainer,
                )
            }
    }
}
