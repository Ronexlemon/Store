package com.example.store.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import com.example.store.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.store.appconstants.AppConstants.checkoutcolor
import com.example.store.appconstants.AppConstants.colors

@Composable
fun CheckOutScreen(price:String?=null){
    Column(modifier= Modifier
        .fillMaxSize()
        .background(color =Color.White )){
        //Text(text="${title}")

        Spacer(modifier= Modifier
            .fillMaxWidth()
            .height(2.dp))
   Card(modifier= Modifier
       .fillMaxSize()
       .padding(top = 32.dp, bottom = 20.dp, end = 16.dp, start = 16.dp)
       ,shape= RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)){
       Column(modifier= Modifier
           .fillMaxSize()
           .background(brush = Brush.horizontalGradient(colors = colors)), verticalArrangement = Arrangement.SpaceEvenly){
           Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
               Column{
                   Text(text="Thank You For Shopping With Us", style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.SansSerif))
                   Text(text="Welcome Back", style = TextStyle(fontSize = 16.sp, fontFamily = FontFamily.SansSerif))
               }

           }
           Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
               Text(text="PayOut ",style= TextStyle(fontWeight = FontWeight.Bold,
                   fontFamily = FontFamily.Serif, fontSize = 20.sp))
               Text(text="$ ${price.toString()}",style= TextStyle(fontWeight = FontWeight.Bold,
                   fontFamily = FontFamily.Serif, fontSize = 20.sp))
           }
           OutlinedButton(modifier=Modifier.width(100.dp).height(50.dp).align(Alignment.CenterHorizontally), shape = RoundedCornerShape(10.dp),onClick = { /*TODO*/ }) {

Icon(painter = painterResource(id =R.drawable.paypal), contentDescription =null )
           }




       }

   }
    }
}
@Preview(showBackground = true)
@Composable
fun Checkout(){
    CheckOutScreen()
}