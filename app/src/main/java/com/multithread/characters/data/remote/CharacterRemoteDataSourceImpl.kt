package com.multithread.characters.data.remote

import com.multithread.characters.data.entities.Character
import com.multithread.characters.data.entities.CharacterList
import retrofit2.Response
import javax.inject.Inject

class CharacterRemoteDataSourceImpl @Inject constructor(private val apiServices: CharacterService ):
        CharacterRemoteDataSource {

    override suspend fun getAllCharacters(): Response<CharacterList> {
        return apiServices.getAllCharacters()
    }

    override suspend fun getCharacter(id: Int): Response<Character> {
        return apiServices.getCharacter(id)
    }

}