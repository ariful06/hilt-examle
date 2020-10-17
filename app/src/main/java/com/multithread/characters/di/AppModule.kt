package com.multithread.characters.di

import com.google.gson.Gson
import com.multithread.characters.data.entities.Character
import com.multithread.characters.data.remote.CharacterRemoteDataSource
import com.multithread.characters.data.remote.CharacterRemoteDataSourceImpl
import com.multithread.characters.data.remote.CharacterService
import com.multithread.characters.data.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideCharacterService(retrofit: Retrofit): CharacterService = retrofit.create(CharacterService::class.java)

}

@Provides
@Singleton
fun provideApiHelper(characterRemoteDataSource : CharacterRemoteDataSourceImpl): CharacterRemoteDataSource = characterRemoteDataSource
