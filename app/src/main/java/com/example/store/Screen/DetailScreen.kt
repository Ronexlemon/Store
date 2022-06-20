package com.example.store.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.store.model.Products

@Composable
fun MainDetailScreen(modifier:Modifier= Modifier,data:Products){
    Scaffold(
        content = {
            DetailContent(data=data)
        }
    )

}

@Composable
fun DetailContent(modifier:Modifier=Modifier,data:Products) {
    Column(modifier.fillMaxSize()){
        Card(
            modifier
                .fillMaxWidth()
                .wrapContentHeight()){
            Image(modifier=Modifier.size(200.dp,200.dp),painter = rememberAsyncImagePainter(model = data.image), contentDescription =null )

        }
        Text(text="${data.description}")

    }
}
