package com.multithread.characters.ui.home.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.multithread.characters.data.entities.Character
import com.multithread.characters.data.entities.CharacterList
import com.multithread.characters.data.repository.CharacterRepository
import com.multithread.characters.utils.NetworkHelper
import com.multithread.characters.utils.Resource
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val characterRepository: CharacterRepository,
    private val networkHelper: NetworkHelper

):ViewModel(){

    private val _characters = MutableLiveData<Resource<CharacterList>>()
    val characters : LiveData<Resource<CharacterList>>
    get() = _characters

    init {
        fetchCharacters()
    }
    private fun fetchCharacters(){
        viewModelScope.launch {
            _characters.postValue(Resource.loading())
            if (networkHelper.isOnline()!!){
                characterRepository.getAllCharacters().let {
                    if (it.isSuccessful){
                        _characters.postValue(Resource.success(it.body()) as Resource<CharacterList>?)
                    }else
                        _characters.postValue(Resource.error(it.errorBody().toString(),null))
                }
            }
        }
    }

}