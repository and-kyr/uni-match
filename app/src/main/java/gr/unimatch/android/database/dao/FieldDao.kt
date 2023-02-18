package gr.unimatch.android.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import gr.unimatch.android.database.entity.Field

@Dao
interface FieldDao {
    @Query("SELECT * FROM field")
    fun getAll(): LiveData<List<Field>>
}
