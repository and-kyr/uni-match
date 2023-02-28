package gr.unimatch.android.ui.details

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import gr.unimatch.android.R
import gr.unimatch.android.database.entity.College

@Composable
fun DetailsHeader(college: College) {
    Text(text = "${college.name}", fontWeight = FontWeight.Bold)

    Spacer(modifier = Modifier.height(6.dp))

    college.mhxCode?.let { Text(text = stringResource(id = R.string.details_mhx_code, it)) }

    Divider(Modifier.padding(vertical = 8.dp), thickness = 2.dp)
}
