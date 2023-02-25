package gr.unimatch.android.ui.results

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.pluralStringResource
import gr.unimatch.android.R

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ResultsHeader(
    totalColleges: Int,
) {
    Text(
        text = pluralStringResource(
            id = R.plurals.college_results_with_selected_filters,
            totalColleges,
            totalColleges,
        ),
    )

    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.results_screen_default_item_spacer)))
}
