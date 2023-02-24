package gr.unimatch.android.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import gr.unimatch.android.AppContainer
import gr.unimatch.android.common.createViewModelFactory

class FiltersViewModel(
    private val savedState: SavedStateHandle,
    private val appContainer: AppContainer,
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
