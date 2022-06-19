package com.example.store.di

import android.content.Context
import androidx.room.Room
import com.example.store.api.StoreService
import com.example.store.appconstants.AppConstants.BaseUrl
import com.example.store.appconstants.AppConstants.DataBaseName
import com.example.store.room.StoreDao
import com.example.store.room.storedatabase.StoreDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
 @Singleton
 @Provides
 fun provideRetrofit(): Retrofit {
      return Retrofit.Builder()
       .baseUrl(BaseUrl)
       .addConverterFactory(GsonConverterFactory.create())
       .build()
 }
 @Singleton
 @Provides
 fun provideApiService(retrofit:Retrofit): StoreService {
  return retrofit.create(StoreService::class.java)
 }
 @Singleton
 @Provides
 fun provideRoom(@ApplicationContext context: Context): StoreDatabase {
  return Room.databaseBuilder(context,StoreDatabase::class.java,
   DataBaseName ).allowMainThreadQueries().build()
 }
 @Singleton
 @Provides
 fun provideDaoService(db:StoreDatabase): StoreDao {
  return db.getDao()
 }

}