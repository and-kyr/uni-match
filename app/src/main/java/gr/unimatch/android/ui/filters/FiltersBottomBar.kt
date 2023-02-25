package gr.unimatch.android.ui.filters

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.pluralStringResource
import gr.unimatch.android.R

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FiltersBottomBar(
    onSearchClicked: () -> Unit,
    totalColleges: Int,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.bottom_bar_padding)),
        contentAlignment = Alignment.Center,
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = onSearchClicked,
        ) {
            Text(
                text = pluralStringResource(
                    id = R.plurals.college_results,
                    totalColleges,
                    totalColleges,
                ),
            )
        }
    }
}
