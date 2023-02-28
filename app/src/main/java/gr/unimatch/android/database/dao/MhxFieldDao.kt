package gr.unimatch.android.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import gr.unimatch.android.database.entity.MhxField

@Dao
interface MhxFieldDao {
    @Query("SELECT * FROM mhx_field")
    fun getAll(): LiveData<List<MhxField>>
}
