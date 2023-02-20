package gr.unimatch.android.viewmodel

import androidx.lifecycle.LiveData
import gr.unimatch.android.database.entity.MhxField

interface MhxFieldsViewModel {
    val mhxFields: LiveData<List<MhxField>>
}
