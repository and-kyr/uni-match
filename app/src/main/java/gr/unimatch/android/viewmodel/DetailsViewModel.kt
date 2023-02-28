package gr.unimatch.android.viewmodel

import androidx.lifecycle.LiveData
import gr.unimatch.android.database.entity.College

interface DetailsViewModel {
    val collegeResult: LiveData<College?>
    fun getCollegeById(id: Int)

    companion object {
        const val COLLEGE_RESULT = "collegeResult"
        val DEFAULT_COLLEGE = null as College?
    }
}
