package com.example.store.di

import com.example.store.api.StoreService
import com.example.store.appconstants.AppConstants.BaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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

}