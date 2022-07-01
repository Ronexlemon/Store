package com.example.store.Screen

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.store.appconstants.AppConstants.colors
import com.example.store.appconstants.AppConstants.colorsScrool
import com.example.store.model.Products
import com.example.store.navigation.NavigationScreens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MainDetailScreen(modifier:Modifier= Modifier,data:Products,scaffoldState: ScaffoldState,navHostController: NavHostController,scope: CoroutineScope){
    Scaffold(
        scaffoldState = scaffoldState,


        content = {
            DetailContent(data=data, navHostController = navHostController, scope = scope)
        }
    )

}

@Composable
fun DetailContent(modifier:Modifier=Modifier, data:Products,navHostController: NavHostController,scope: CoroutineScope) {

    Column(
        modifier
            .fillMaxSize()
            .background(brush= Brush.linearGradient(colors=colors))
            .verticalScroll(rememberScrollState())){
        Card(
            modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(brush= Brush.verticalGradient(colors= colorsScrool))
                .shadow(elevation = 10.dp, shape = RectangleShape),shape= RoundedCornerShape(20.dp)){
            Image(modifier= Modifier
                .height(300.dp)
                .fillMaxWidth()
                .background(color=Color.White),painter = rememberAsyncImagePainter(model = data.image), contentDescription =null )

        }

        Text(text="${data.description}",modifier.padding(8.dp),
        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Black)
                )
        Text(text=" $ ${data.price}",modifier.padding(8.dp),
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Black))


Row(modifier.fillMaxWidth(),verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.End,){
    OutlinedButton(onClick = {scope.launch {
        navHostController.navigate(NavigationScreens.CheckOut.route.plus("/${data.price}"))
    }


     }) {
        Icon(Icons.Default.ShoppingCart,contentDescription = null)

    }
}
    }
}

