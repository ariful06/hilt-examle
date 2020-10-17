package com.multithread.characters.data.repository

import com.multithread.characters.data.remote.CharacterService
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val apiService: CharacterService) {

    suspend fun getAllCharacters() = apiService.getAllCharacters()

    suspend fun getCharacter(id: Int) = apiService.getCharacter(id)
}