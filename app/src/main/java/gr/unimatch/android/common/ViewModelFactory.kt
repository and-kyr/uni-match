package gr.unimatch.android.common

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import gr.unimatch.android.AppContainer
import gr.unimatch.android.UniMatchApplication

fun <VM : ViewModel> createViewModelFactory(
    viewModelConstructor: (savedStateHandle: SavedStateHandle, appContainer: AppContainer) -> VM,
) = object : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras,
    ): T {
        val application =
            checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
        val savedStateHandle = extras.createSavedStateHandle()

        return viewModelConstructor(
            savedStateHandle,
            (application as UniMatchApplication).appContainer,
        ) as T
    }
}
