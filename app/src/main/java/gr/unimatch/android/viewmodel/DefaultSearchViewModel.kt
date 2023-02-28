package gr.unimatch.android.viewmodel

import androidx.lifecycle.*
import gr.unimatch.android.common.createViewModelFactory
import gr.unimatch.android.database.entity.College
import gr.unimatch.android.repository.CollegesRepository
import gr.unimatch.android.viewmodel.SearchViewModel.Companion.COLLEGES_RESULT
import gr.unimatch.android.viewmodel.SearchViewModel.Companion.DEFAULT_COLLEGES
import kotlinx.coroutines.launch

class DefaultSearchViewModel(
    private val savedState: SavedStateHandle,
    private val collegesRepository: CollegesRepository,
) : ViewModel(), SearchViewModel {

    override val totalColleges: LiveData<Int> =
        collegesResult.map { it.size }

    private var collegesResultValue: List<College>
        get() = savedState[COLLEGES_RESULT] ?: DEFAULT_COLLEGES
        set(value) {
            savedState[COLLEGES_RESULT] = value
        }

    override val collegesResult: LiveData<List<College>>
        get() = savedState.getLiveData(
            key = COLLEGES_RESULT,
            initialValue = DEFAULT_COLLEGES,
        ).distinctUntilChanged()

    override fun getCollegesByIds(ids: Set<Int>) {
        viewModelScope.launch {
            collegesResultValue = collegesRepository.getColleges(ids)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory =
            createViewModelFactory { savedStateHandle, appContainer ->
                DefaultSearchViewModel(
                    savedState = savedStateHandle,
                    collegesRepository = appContainer.collegesRepository,
                )
            }
    }
}
