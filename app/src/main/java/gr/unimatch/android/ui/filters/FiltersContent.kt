package gr.unimatch.android.ui.filters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import gr.unimatch.android.R
import gr.unimatch.android.viewmodel.FieldsViewModel
import gr.unimatch.android.viewmodel.FiltersViewModel
import gr.unimatch.android.viewmodel.MhxFieldsViewModel.Companion.DEFAULT_MHX_FIELDS

@Composable
fun FiltersContent(
    viewModel: FiltersViewModel,
    onSearchClicked: () -> Unit,
) {
    val totalColleges by viewModel.totalCollegesFromSelectedFilters.observeAsState(0)
    val mhxFields by viewModel.mhxFields.observeAsState(DEFAULT_MHX_FIELDS)
    val selectedMhxFields by viewModel.selectedMhxFields.observeAsState(DEFAULT_MHX_FIELDS)
    val fields by viewModel.fields.observeAsState(FieldsViewModel.DEFAULT_FIELDS)
    val selectedFields by viewModel.selectedFields.observeAsState(FieldsViewModel.DEFAULT_FIELDS)

    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(horizontal = dimensionResource(id = R.dimen.filters_screen_horizontal_padding))
                    .verticalScroll(rememberScrollState()),
            ) {

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.filters_screen_default_filter_spacer)))

                MhxFieldsFilter(
                    mhxFields = mhxFields,
                    selectedMhxFields = selectedMhxFields.toSet(),
                    onMhxFieldClicked = {
                        if (it !in selectedMhxFields)
                            viewModel.onMhxFieldAdded(it)
                        else
                            viewModel.onMhxFieldRemoved(it)
                    }
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.filters_screen_default_filter_spacer)))

                FieldsFilter(
                    fields = fields,
                    selectedFields = selectedFields.toSet(),
                    onFieldClicked = {
                        if (it !in selectedFields)
                            viewModel.onFieldAdded(it)
                        else
                            viewModel.onFieldRemoved(it)
                    }
                )
            }
        },
        bottomBar = {
            FiltersBottomBar(
                onSearchClicked = onSearchClicked,
                totalColleges = totalColleges,
            )
        }
    )
}
