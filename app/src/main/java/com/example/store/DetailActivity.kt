package com.example.store

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.store.Screen.MainDetailScreen
import com.example.store.model.Products
import com.example.store.ui.theme.StoreTheme

class DetailActivity : ComponentActivity() {
    private val data:Products by lazy{
        intent?.getSerializableExtra(tittle) as Products
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StoreTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainDetailScreen(data = data)
                }
            }
        }
    }
    companion object{
        private const  val tittle = "tittle"

        fun newIntent(context: Context, data:Products)= Intent(context,DetailActivity::class.java).apply {
            putExtra(tittle,data)


        }

    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    StoreTheme {
        Greeting2("Android")
    }
}