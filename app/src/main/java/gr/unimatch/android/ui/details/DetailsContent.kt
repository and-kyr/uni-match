package gr.unimatch.android.ui.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gr.unimatch.android.viewmodel.DefaultDetailsViewModel

@Composable
fun DetailsContent(
    viewModel: DefaultDetailsViewModel,
    onSiteLinkClicked: (String) -> Unit,
) {
    val collegeResult by viewModel.collegeResult.observeAsState()

    collegeResult?.let { college ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
        ) {
            DetailsHeader(college)

            Spacer(modifier = Modifier.height(12.dp))

            DetailsInfoSection(college, onSiteLinkClicked)

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
