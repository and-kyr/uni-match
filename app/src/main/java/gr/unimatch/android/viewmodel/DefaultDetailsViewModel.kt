package gr.unimatch.android.viewmodel

import androidx.lifecycle.*
import gr.unimatch.android.common.createViewModelFactory
import gr.unimatch.android.database.entity.College
import gr.unimatch.android.repository.CollegesRepository
import gr.unimatch.android.viewmodel.DetailsViewModel.Companion.COLLEGE_RESULT
import gr.unimatch.android.viewmodel.DetailsViewModel.Companion.DEFAULT_COLLEGE
import kotlinx.coroutines.launch

class DefaultDetailsViewModel(
    private val savedState: SavedStateHandle,
    private val collegesRepository: CollegesRepository,
) : ViewModel(), DetailsViewModel {
    private var collegeResultValue: College?
        get() = savedState[COLLEGE_RESULT] ?: DEFAULT_COLLEGE
        set(value) {
            savedState[COLLEGE_RESULT] = value
        }

    override val collegeResult: LiveData<College?>
        get() = savedState.getLiveData(
            key = COLLEGE_RESULT,
            initialValue = DEFAULT_COLLEGE,
        ).distinctUntilChanged()

    override fun getCollegeById(id: Int) {
        viewModelScope.launch {
            collegeResultValue = collegesRepository.getCollegeById(id)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory =
            createViewModelFactory { savedStateHandle, appContainer ->
                DefaultDetailsViewModel(
                    savedState = savedStateHandle,
                    collegesRepository = appContainer.collegesRepository,
                )
            }
    }
}
