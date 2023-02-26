package gr.unimatch.android.ui.results

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import gr.unimatch.android.R
import gr.unimatch.android.viewmodel.DefaultSearchViewModel
import gr.unimatch.android.viewmodel.SearchViewModel.Companion.DEFAULT_COLLEGES

@Composable
fun ResultsContent(
    viewModel: DefaultSearchViewModel,
    onCollegeClicked: (Int) -> Unit,
) {
    val totalColleges by viewModel.totalColleges.observeAsState(0)
    val colleges by viewModel.collegesResult.observeAsState(DEFAULT_COLLEGES)

    LazyColumn(
        modifier = Modifier.padding(dimensionResource(id = R.dimen.results_screen_content_padding)),
    ) {
        item {
            ResultsHeader(
                totalColleges = totalColleges,
            )
        }

        items(colleges) { college ->
            college.name?.let {
                ResultsItem(
                    college = college,
                    onCollegeClicked = onCollegeClicked,
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.results_screen_default_item_spacer)))
            }
        }
    }
}
