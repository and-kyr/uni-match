package gr.unimatch.android.viewmodel

import androidx.lifecycle.LiveData
import gr.unimatch.android.database.entity.College

interface SearchViewModel {
    val collegesResult: LiveData<List<College>>
    val totalColleges: LiveData<Int>
    fun getCollegesByIds(ids: Set<Int>)

    companion object {
        const val COLLEGES_RESULT = "collegesResult"
        val DEFAULT_COLLEGES = listOf<College>()
    }
}
