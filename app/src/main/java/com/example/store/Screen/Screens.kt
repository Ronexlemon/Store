package com.example.store.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.store.Greeting
import com.example.store.model.Products
import com.example.store.storviemodel.StoreViewModel

@Composable
fun MainScreen(modifier:Modifier= Modifier,viemodel: StoreViewModel,scaffoldState: ScaffoldState){
    Scaffold(
        scaffoldState = scaffoldState,
        content = {
AllProductScreen(viemodel=viemodel )

        }
    )



}
@Composable
fun AllProductScreen(modifier:Modifier = Modifier,viemodel: StoreViewModel){
    val state by viemodel.state.collectAsState()
    Column(modifier.fillMaxSize()){

        LazyColumn{
            items(items=state, itemContent = {item->
                ProductsItem(data = item)

            })
        }

    }
}

@Composable
fun ProductsItem(modifier:Modifier=Modifier,data:Products) {
    Card(
        modifier
            .fillMaxWidth()
            .wrapContentHeight()){
        Column(modifier.fillMaxSize()) {
            Text(text="${data.title}")

        }

    }

}
