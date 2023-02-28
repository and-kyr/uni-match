package gr.unimatch.android.ui.filters

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import gr.unimatch.android.R
import gr.unimatch.android.database.entity.Field

@Composable
fun ColumnScope.FieldsFilter(
    fields: List<Field>,
    selectedFields: Set<Field>,
    onFieldClicked: (Field) -> Unit,
) {
    Text(
        modifier = Modifier
            .align(Alignment.CenterHorizontally),
        text = stringResource(id = R.string.fields_filter_label),
    )

    Divider(
        modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.divider_default_vertical_padding)),
    )

    fields.forEach {
        if (it.name != null) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.small)
                    .background(color = if (it !in selectedFields) Color.Transparent else Color.Green)
                    .padding(dimensionResource(id = R.dimen.filters_screen_filter_items_default_padding))
                    .clickable { onFieldClicked(it) },
                text = it.name,
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.filters_screen_filter_items_default_spacer)))
        }
    }
}
