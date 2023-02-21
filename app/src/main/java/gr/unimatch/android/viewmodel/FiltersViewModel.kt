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
    FieldsViewModel by DefaultFieldsViewModel(savedState, appContainer.fieldsRepository),
    MhxFieldsViewModel by DefaultMhxFieldsViewModel(
        savedState,
        appContainer.mhxFieldsRepository,
        appContainer.collegeMhxFieldsRepository,
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
