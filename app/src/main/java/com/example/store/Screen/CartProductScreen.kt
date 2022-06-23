package com.example.store.Screen

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.store.model.Cart
import com.example.store.storviemodel.StoreViewModel

@Composable
fun MainCartScreen(  scafoldstate:ScaffoldState,viewModel: StoreViewModel){
    Scaffold(
        scaffoldState = scafoldstate,
        content = {
            CartProducts(viewModel = viewModel)
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CartProducts(viewModel: StoreViewModel) {
    val cart by viewModel.cart.collectAsState()

    Column{
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)

        ) {

            items(cart) { item ->
                ProductsCartItem(data = item)

            }}

    }
}

@Composable
fun ProductsCartItem(modifier: Modifier = Modifier, data: Cart) {

    val context = LocalContext.current
    Card(
        modifier
            .fillMaxWidth()
            .height(370.dp)
            .background(color = MaterialTheme.colors.background)
            .padding(8.dp), shape = RoundedCornerShape(20.dp)
    ){
        Column(
            modifier
                .fillMaxSize()
                .clickable {  }, verticalArrangement = Arrangement.SpaceEvenly) {

            Text(text="${data.date}",modifier.padding(8.dp))
            Text(text="${data.id}",modifier.padding(8.dp))
            Toast.makeText(context," id is :${data.date}",Toast.LENGTH_SHORT).show()
           // Text(text="Ksh${data.price}",modifier.padding(8.dp), style = TextStyle(fontWeight = FontWeight.ExtraBold, fontSize = 20.sp))

        }

    }

}
