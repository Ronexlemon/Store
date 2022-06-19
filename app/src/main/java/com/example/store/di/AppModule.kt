package com.example.store.di

import android.content.Context
import androidx.room.Room
import com.example.store.api.StoreService
import com.example.store.appconstants.AppConstants.BaseUrl
import com.example.store.appconstants.AppConstants.DataBaseName
import com.example.store.room.StoreDao
import com.example.store.room.storedatabase.StoreDatabase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
 @Provides
 fun providesLoggingInterceptor(): HttpLoggingInterceptor {
  return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
 }




 @Provides
 fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
  val okHttpClient = OkHttpClient().newBuilder()

  okHttpClient.callTimeout(40, TimeUnit.SECONDS)
  okHttpClient.connectTimeout(40, TimeUnit.SECONDS)
  okHttpClient.readTimeout(40, TimeUnit.SECONDS)
  okHttpClient.writeTimeout(40, TimeUnit.SECONDS)
  okHttpClient.addInterceptor(loggingInterceptor)
  okHttpClient.build()
  return okHttpClient.build()
 }


 @Singleton
 @Provides
 fun provideConverterFactory(): Converter.Factory {
  return GsonConverterFactory.create()
 }
 @Singleton
 @Provides
 fun provideRetrofit(okHttpClient: OkHttpClient,converter:Converter.Factory): Retrofit {
      return Retrofit.Builder()
       .baseUrl(BaseUrl)
       .client(okHttpClient)
       .addConverterFactory(converter)
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