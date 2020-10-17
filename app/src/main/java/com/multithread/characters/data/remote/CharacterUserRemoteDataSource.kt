package com.multithread.characters.data.remote

import com.multithread.characters.data.entities.Character
import com.multithread.characters.data.entities.CharacterList
import retrofit2.Response

interface CharacterRemoteDataSource {
    suspend fun getAllCharacters(): Response<CharacterList>
    suspend fun getCharacter(id : Int): Response<Character>
}