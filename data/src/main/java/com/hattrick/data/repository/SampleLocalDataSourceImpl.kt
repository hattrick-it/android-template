package com.hattrick.data.repository

import com.hattrick.data.db.SampleDao
import com.hattrick.data.model.SampleDataModel

class SampleLocalDataSourceImpl(private val sampleDao: SampleDao) : SampleLocalDataSource {
    override suspend fun saveElementToDb(sampleDataModel: SampleDataModel) {
        sampleDao.save(sampleDataModel)
    }

    override suspend fun clearDb() {
        sampleDao.deleteAll()
    }

    override suspend fun deleteElementFromDb(int: Int) {
        sampleDao.deleteOne(int)
    }

    override suspend fun getAllFromDb(): List<SampleDataModel> = sampleDao.getAll()

    override suspend fun getElementFromDb(int: Int): SampleDataModel = sampleDao.getOne(int)
}