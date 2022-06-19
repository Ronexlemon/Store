package com.example.store.storviemodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.store.model.Products

import com.example.store.storerepository.StoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class StoreViewModel
    @Inject constructor(private val repo:StoreRepository): ViewModel() {
    val _state = MutableStateFlow(emptyList<Products>())
    val state:StateFlow<List<Products>>
    get() = _state
    //if you're using the xml pprocess
//        var _response = MutableLiveData<List<Products>>()
//    val response:LiveData<List<Products>>
//    get() = _response
    init {
      // getDataResponse()
  getDataRes()
    }

    private fun getDataRes() {
        viewModelScope.launch {
            val prod= repo.getAllProducts()
            _state.value = prod.body()!!
        }
    }


//    private fun getDataResponse() {
//        viewModelScope.launch {
//            repo.getAllProducts().let { response->
//                if(response.isSuccessful){
//                   val data= _response.postValue(response.body())
//
//
//                }
//            }
//        }
//    }

}