package com.hattrick.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hattrick.data.model.SampleDataModel

@Dao
interface SampleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(sampleDataModel: SampleDataModel)

    @Query("DELETE FROM sample_table")
    suspend fun deleteAll()

    @Query("DELETE FROM sample_table WHERE int = :int")
    suspend fun deleteOne(int: Int)

    @Query("SELECT * FROM sample_table")
    suspend fun getAll(): List<SampleDataModel>

    @Query("SELECT * FROM sample_table WHERE int = :int")
    suspend fun getOne(int: Int): SampleDataModel
}