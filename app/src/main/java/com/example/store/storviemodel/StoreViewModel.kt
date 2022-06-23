package com.example.store.storviemodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.store.model.Cart
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
    //get a list of the cart
    val _cart = MutableStateFlow(emptyList<Cart>())
    val cart :StateFlow<List<Cart>>
    get() =  _cart
    var progress by  mutableStateOf(false)
 var id by mutableStateOf(1)




//   // if you're using the xml pprocess
//        var _response = MutableLiveData<List<Products>>()
//    val response:LiveData<List<Products>>
//    get() = _response
    init {
      // getDataResponse()

  getDataRes()


    }
    //get product cart
    public  fun getAllProduct(){
        viewModelScope.launch {
           val cartItem = repo.getAllCart(id)
            _cart.value = cartItem.body()!!
        }
    }

    //get products category

    public fun getWomenResponse() {

            viewModelScope.launch {
                val women = repo.getAllWomens()
                _state.value = women.body()!!
               progress=true

        }

    }

    public fun getMenResponse() {
        viewModelScope.launch {
            val men = repo.getAllMens()
            _state.value = men.body()!!
            progress=true

        }
    }

    public fun getElectronicResponse() {
        viewModelScope.launch{
            val electronic =repo.getAllElectronics()
            _state.value =electronic.body()!!
            progress=true

        }
    }

    public fun getJeweryResponse() {
        viewModelScope.launch {
            val jewery = repo.getAllJewery()
            _state.value = jewery.body()!!
            progress=true

        }
    }

    public fun getDataRes() {
        viewModelScope.launch {
            val prod= repo.getAllProducts()
            _state.value = prod.body()!!
            progress=true

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