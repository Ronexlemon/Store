package com.example.store.Screen

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.RoundedCorner
import android.widget.ProgressBar
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.store.Greeting
import com.example.store.R
import com.example.store.appconstants.AppConstants.colorbackground
import com.example.store.appconstants.AppConstants.colors
import com.example.store.appconstants.AppConstants.colorsScrool
import com.example.store.model.Products
import com.example.store.model.autoScrollingList
import com.example.store.navigation.NavigationScreens
import com.example.store.storviemodel.StoreViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MainScreen(modifier:Modifier= Modifier,viemodel: StoreViewModel,scaffoldState: ScaffoldState,navHostController: NavHostController,scope: CoroutineScope,onItemclick:(Products)->Unit){
    Scaffold(
        scaffoldState = scaffoldState
    ,
    ) {

        AllProductScreen(viemodel = viemodel, onItemclick = onItemclick)

    }


}


@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AllProductScreen(modifier:Modifier = Modifier,viemodel: StoreViewModel,onItemclick:(Products)->Unit){

    val category by viemodel.state.collectAsState()
    val scope = rememberCoroutineScope()

    Column(modifier.fillMaxSize().background(brush= Brush.horizontalGradient(colors=colorbackground))){
        Landingpage(viemodel = viemodel)

//        LazyColumn{
//            items(items=state, itemContent = {item->
//                ProductsItem(data = item)
//
//            })
//        }
        when(val resource = viemodel.progress) {
            true -> {
                scope.launch {
                    delay(1000L)
                    viemodel.progress=false
                }
                CustomLinearProgressBar()}
            false ->

                LazyVerticalGrid(
                    cells = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)

                ) {

                    items(category) { item ->
                        ProductsItem(data = item, onItemclick = onItemclick)

                    }
                }
        }


    }
}

@Composable
fun ProductsItem(modifier:Modifier=Modifier,data:Products,onItemclick:(Products)->Unit) {
    Card(
        modifier
            .fillMaxWidth()
            .height(370.dp)
            .background(color = MaterialTheme.colors.background)
            .padding(8.dp), shape = RoundedCornerShape(20.dp)){
        Column(
            modifier
                .fillMaxSize()
                .background(brush = Brush.verticalGradient(colors = colors))
                .clickable { onItemclick(data) }, verticalArrangement = Arrangement.SpaceEvenly) {
            Image(painter = rememberAsyncImagePainter(data.image), contentDescription =null,
                modifier
                    .size(100.dp, 100.dp)
                    .align(Alignment.CenterHorizontally) )
            Text(text="${data.title}",modifier.padding(8.dp))
            Text(text="${data.category}",modifier.padding(8.dp))
            Text(text="$ ${data.price}",modifier.padding(8.dp), style = TextStyle(fontWeight = FontWeight.ExtraBold, fontSize = 20.sp))

        }

    }

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Landingpage(modifier:Modifier = Modifier,viemodel: StoreViewModel){
    var name by remember{ mutableStateOf(false)}


    val category by viemodel.state.collectAsState()

    Column {


LandingPageCard()
        LazyRow {
            item {
                OutlinedButton(onClick = {viemodel.getDataRes()}, shape = RoundedCornerShape(15.dp),modifier= Modifier
                    .size(height = 60.dp, width = 125.dp)
                    .padding(8.dp)) {
                    Text(
                        text = "All",
                        style = TextStyle(
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    )

                }
            }
            item {
                OutlinedButton(onClick = { viemodel.getJeweryResponse() },
                    shape = RoundedCornerShape(15.dp),modifier= Modifier
                    .size(height = 60.dp, width = 125.dp)
                    .padding(8.dp)){
                    Text(
                        text = "Jewelery",
                        style = TextStyle(
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    )

                }
            }
            item {
                OutlinedButton( onClick = { viemodel.getElectronicResponse() }, shape = RoundedCornerShape(15.dp),modifier= Modifier
                    .size(height = 60.dp, width = 150.dp)
                    .padding(8.dp)
                   ) {
                    Text(
                        text = "Electronic",
                        style = TextStyle(
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    )

                }
            }
            item {
                OutlinedButton(onClick = { viemodel.getWomenResponse() }, shape = RoundedCornerShape(15.dp),modifier= Modifier
                    .size(height = 60.dp, width = 200.dp)
                    .padding(8.dp)){
                    Text(
                        text = "Women's Clothes",
                        style = TextStyle(
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    )

                }
            }
            item {
                OutlinedButton(onClick = { viemodel.getMenResponse() }, shape = RoundedCornerShape(15.dp),modifier= Modifier
                    .size(height = 60.dp, width = 100.dp)
                    .padding(8.dp)) {
                    Text(
                        text = "Men",
                        style = TextStyle(
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    )

                }
            }

        }
    }
}
@Composable
fun LandingPageCard(modifier:Modifier= Modifier){
    Column(
        modifier
            .fillMaxWidth()
            .padding(top=25.dp)
            .height(250.dp)){

       AutoScrollingList(list = autoScrollingList )
    }


}

@Composable
fun SearchBar(modifier:Modifier=Modifier) {
    var search by remember{ mutableStateOf("")}
    Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null,
            modifier
                .size(50.dp)
                .clip(CircleShape)
                .align(Alignment.CenterVertically)
                .padding(start = 8.dp), contentScale = ContentScale.Crop)
        OutlinedTextField(value =search , onValueChange ={
            search=it
        }, shape = RoundedCornerShape(10.dp),modifier= Modifier

            .padding(top = 16.dp, start = 2.dp, end = 2.dp, bottom = 8.dp))
Button(onClick = { /*TODO*/ },shape= RoundedCornerShape(15.dp),modifier=Modifier.align(Alignment.CenterVertically)) {
    Icon(Icons.Default.Search,contentDescription = null)

}
    }
}
@Composable
private fun CustomLinearProgressBar(){
    Column(modifier = Modifier.fillMaxWidth()) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp),
            backgroundColor = Color.LightGray,
            color = Color.Red //progress color
        )
    }
}