package com.hattrick.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hattrick.domain.model.SampleModel

@Entity(tableName = "sample_table")
data class SampleDataModel(
    @PrimaryKey
    val id: Int,
    val name: String,
    val number: Float
)

fun SampleDataModel.toDomain(): SampleModel = SampleModel(name = name)
