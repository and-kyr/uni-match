package gr.unimatch.android.ui.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Surface
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import gr.unimatch.android.common.setContent
import gr.unimatch.android.ui.theme.UniMatchTheme
import gr.unimatch.android.viewmodel.DefaultSearchViewModel

class ResultsScreen : Fragment() {
    private val viewModel by viewModels<DefaultSearchViewModel> { DefaultSearchViewModel.Factory }
    private val args: ResultsScreenArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getCollegesByIds(args.collegeIds.toSet())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = setContent {
        UniMatchTheme {
            Surface {
                ResultsContent(
                    viewModel = viewModel,
                    onCollegeClicked = {},
                )
            }
        }
    }
}
