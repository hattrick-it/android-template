package com.hattrick.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hattrick.data.model.SampleDataModel

@Database(
    entities = [SampleDataModel::class],
    version = 1,
    exportSchema = false
)
abstract class SampleDatabase : RoomDatabase() {
    abstract fun sampleDao(): SampleDao
}