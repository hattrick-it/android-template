package com.hattrick.myapplication.di

import android.app.Application
import androidx.room.Room
import com.hattrick.data.DConstants
import com.hattrick.data.api.ApiService
import com.hattrick.data.db.SampleDao
import com.hattrick.data.db.SampleDatabase
import com.hattrick.data.repository.*
import com.hattrick.domain.repository.SampleRepository
import com.hattrick.domain.usecase.SampleUseCase
import com.hattrick.domain.usecase.SampleUseCaseImpl
import com.hattrick.myapplication.presentation.viewmodel.ScreenTwoViewModel
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    viewModel { ScreenTwoViewModel() }

    factory<SampleUseCase> { SampleUseCaseImpl(get()) }
    factory<SampleRepository> { SampleRepositoryImpl(get(), get(), get()) }

    single { Dispatchers.IO }

    //region database
    factory<SampleLocalDataSource> { SampleLocalDataSourceImpl(get()) }

    fun provideDatabase(application: Application): SampleDatabase {
        return Room.databaseBuilder(application, SampleDatabase::class.java, "sample_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideSampleDao(database: SampleDatabase): SampleDao {
        return database.sampleDao()
    }

    single { provideDatabase(androidApplication()) }
    single { provideSampleDao(get()) }
    //endregion

    //region retrofit
    factory<SampleRemoteDataSource> { SampleRemoteDataSourceImpl(get()) }
    fun getApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    single { getApiService(get()) }

    fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { provideRetrofit(get(), DConstants.BASE_URL) }
    //endregion

    //region okhttp
    fun createOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    single { createOkHttpClient() }
    //endregion
}