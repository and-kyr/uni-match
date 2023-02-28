package gr.unimatch.android.ui.details

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import gr.unimatch.android.R

@Composable
fun ExpandableButtonText(
    modifier: Modifier = Modifier,
    expanded: Boolean,
    onClick: () -> Unit,
) {
    val color = if (expanded) Color.DarkGray else Color.LightGray
    val label = if (expanded) R.string.show_less else R.string.show_more
    val iconRotation by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
    )

    Row(
        modifier = modifier.clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(id = label),
            color = color,
        )

        Icon(
            modifier = Modifier
                .padding(start = 4.dp)
                .rotate(iconRotation),
            painter = painterResource(id = R.drawable.ic_arrow_down),
            tint = color,
            contentDescription = stringResource(id = R.string.expandable_button_text_content_description),
        )
    }
}
