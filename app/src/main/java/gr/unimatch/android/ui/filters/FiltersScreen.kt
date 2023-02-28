package gr.unimatch.android.ui.filters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Surface
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import gr.unimatch.android.common.setContent
import gr.unimatch.android.ui.theme.UniMatchTheme
import gr.unimatch.android.viewmodel.FiltersViewModel

class FiltersScreen : Fragment() {
    private val viewModel by viewModels<FiltersViewModel> { FiltersViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = setContent {
        UniMatchTheme {
            Surface {
                FiltersContent(
                    viewModel = viewModel,
                    onSearchClicked = ::goToResultsScreen,
                )
            }
        }
    }

    private fun goToResultsScreen() {
        val action = FiltersScreenDirections.actionFiltersScreenToResultsScreen(
            viewModel.collegeIdsResult.toIntArray()
        )
        findNavController().navigate(action)
    }
}
