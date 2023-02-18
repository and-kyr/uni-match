package gr.unimatch.android.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import gr.unimatch.android.database.entity.*
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

const val DATABASE_VERSION = 1
const val DATABASE_NAME = "universities_database"

@Database(
    entities = [City::class, College::class, CollegeField::class, CollegeMhxField::class, Field::class, Lesson::class, MhxField::class],
    version = DATABASE_VERSION,
    exportSchema = false,
)
@OptIn(InternalCoroutinesApi::class)
abstract class UniversitiesDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var Instance: UniversitiesDatabase? = null

        fun get(context: Context): UniversitiesDatabase =
            Instance ?: synchronized(this) { createDatabase(context) }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context = context,
                klass = UniversitiesDatabase::class.java,
                name = DATABASE_NAME,
            )
                .fallbackToDestructiveMigration()
                .build()
                .also { Instance = it }
    }
}
