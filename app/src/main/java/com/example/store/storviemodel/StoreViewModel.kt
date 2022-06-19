package com.example.store.storviemodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.store.model.Products

import com.example.store.storerepository.StoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class StoreViewModel
    @Inject constructor(private val repo:StoreRepository): ViewModel() {
        var _response = MutableLiveData<List<Products>>()
    val response:LiveData<List<Products>>
    get() = _response
    init {
        getDataResponse()

    }

    private fun getDataResponse() {
        viewModelScope.launch {
            repo.getAllProducts().let { response->
                if(response.isSuccessful){
                   val data= _response.postValue(response.body())

                }
            }
        }
    }

}