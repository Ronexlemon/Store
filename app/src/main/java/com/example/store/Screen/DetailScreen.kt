package com.example.store.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())){
        Card(
            modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .shadow(elevation = 10.dp, shape = RectangleShape),shape= RoundedCornerShape(20.dp)){
            Image(modifier= Modifier
                .height(300.dp)
                .fillMaxWidth(),painter = rememberAsyncImagePainter(model = data.image), contentDescription =null )

        }

        Text(text="${data.description}",modifier.padding(8.dp),
        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Black)
                )
        Text(text=" Ksh${data.price}",modifier.padding(8.dp),
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Black))


Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.End){
    OutlinedButton(onClick = { /*TODO*/ }) {
        Icon(Icons.Default.ShoppingCart,contentDescription = null)

    }
}
    }
}
