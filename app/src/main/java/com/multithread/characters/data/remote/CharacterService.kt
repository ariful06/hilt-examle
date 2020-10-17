package com.multithread.characters.data.remote

import com.multithread.characters.data.entities.Character
import com.multithread.characters.data.entities.CharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService{
    @GET("character")
    suspend fun getAllCharacters(): Response<CharacterList>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("Id") id: Int): Response<Character>
}