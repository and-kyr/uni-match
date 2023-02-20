package gr.unimatch.android.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import gr.unimatch.android.common.createViewModelFactory
import gr.unimatch.android.repository.MhxFieldsRepository

class DefaultMhxFieldsViewModel(
    private val savedState: SavedStateHandle,
    private val mhxFieldsRepository: MhxFieldsRepository,
) : ViewModel(), MhxFieldsViewModel {
    override val mhxFields = mhxFieldsRepository.getMhxFields()

    companion object {
        val Factory: ViewModelProvider.Factory =
            createViewModelFactory { savedStateHandle, appContainer ->
                DefaultMhxFieldsViewModel(
                    savedState = savedStateHandle,
                    mhxFieldsRepository = appContainer.mhxFieldsRepository,
                )
            }
    }
}
