package com.example.fitnessapp.di

import com.example.fitnessapp.api.AuthInterceptor
import com.example.fitnessapp.api.BodyPartExerciseAPI
import com.example.fitnessapp.api.TargetExerciseAPI
import com.example.fitnessapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun providesRetrofit( okHttpClient: OkHttpClient ) : Retrofit.Builder{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(BASE_URL)
    }

    @Singleton
    @Provides
    fun providesOkHttpClient( authInterceptor: AuthInterceptor) : OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(authInterceptor).build()
    }


    @Singleton
    @Provides
    fun providesBodyPartExerciesAPI(retrofitBuilder : Retrofit.Builder ) : BodyPartExerciseAPI{
        return retrofitBuilder.build().create(BodyPartExerciseAPI::class.java)
    }

    @Singleton
    @Provides
    fun providesTargetExerciesAPI( retrofitBuilder: Retrofit.Builder ) : TargetExerciseAPI{
        return retrofitBuilder.build().create(TargetExerciseAPI::class.java)
    }
}