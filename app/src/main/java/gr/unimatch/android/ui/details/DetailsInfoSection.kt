package gr.unimatch.android.ui.details

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import gr.unimatch.android.R
import gr.unimatch.android.database.entity.College

private const val COLLEGE_DESCRIPTION_MAX_LINES = 5

@Composable
fun ColumnScope.DetailsInfoSection(
    college: College,
    onSiteLinkClicked: (String) -> Unit
) {
    college.university?.let {
        DetailsUniversityInfo(university = it)
    }

    Spacer(modifier = Modifier.height(40.dp))

    college.info?.let {
        DetailsCollegeInfo(info = it)
    }

    Spacer(modifier = Modifier.height(24.dp))

    college.site?.let {
        DetailsSiteInfo { onSiteLinkClicked(it) }
    }
}

@Composable
private fun DetailsUniversityInfo(university: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            modifier = Modifier
                .padding(end = 8.dp),
            painter = painterResource(id = R.drawable.ic_university),
            contentDescription = stringResource(id = R.string.details_university_icon_content_description),
        )
        Text(text = university)
    }
}

@Composable
private fun ColumnScope.DetailsCollegeInfo(info: String) {
    var hasVisualOverflow by remember { mutableStateOf(false) }
    var isSeeMoreExpanded by remember { mutableStateOf(false) }
    val maxLines by remember {
        derivedStateOf {
            if (isSeeMoreExpanded) Int.MAX_VALUE else COLLEGE_DESCRIPTION_MAX_LINES
        }
    }

    Text(
        modifier = Modifier.animateContentSize(),
        text = info,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines,
        onTextLayout = { textLayoutResult ->
            hasVisualOverflow = textLayoutResult.hasVisualOverflow
        }
    )

    Spacer(modifier = Modifier.height(8.dp))

    if (hasVisualOverflow || isSeeMoreExpanded) {
        ExpandableButtonText(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            expanded = isSeeMoreExpanded,
            onClick = { isSeeMoreExpanded = !isSeeMoreExpanded },
        )
    }
}

@Composable
private fun DetailsSiteInfo(onSiteLinkClicked: () -> Unit) {
    Text(
        modifier = Modifier.clickable { onSiteLinkClicked() },
        text = stringResource(id = R.string.visit_college_website),
        textDecoration = TextDecoration.Underline,
        color = Color.Blue,
    )
}
