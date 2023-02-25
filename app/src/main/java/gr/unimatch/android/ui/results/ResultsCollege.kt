package gr.unimatch.android.ui.results

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import gr.unimatch.android.R
import gr.unimatch.android.database.entity.College

@Composable
fun ResultsItem(
    college: College,
    onSiteLinkClicked: (String) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(
            width = dimensionResource(id = R.dimen.results_screen_item_card_border),
            color = Color.LightGray,
        ),
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.results_screen_item_card_content_padding)),
        ) {
            Text(
                text = "${college.name}",
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            college.university?.let { Text(text = it) }

            Spacer(modifier = Modifier.height(12.dp))

            college.site?.let {
                Text(
                    modifier = Modifier.clickable { onSiteLinkClicked(it) },
                    text = stringResource(id = R.string.visit_college_website),
                    textDecoration = TextDecoration.Underline,
                    color = Color.Blue,
                )
            }
        }
    }
}
