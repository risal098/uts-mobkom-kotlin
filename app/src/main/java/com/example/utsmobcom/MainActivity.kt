    package com.example.utsmobcom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.utsmobcom.ui.theme.UtsmobcomTheme
import com.example.utsmobcom.R
import com.example.utsmobcom.type.Book
import java.util.function.Consumer


    val Data = mutableListOf<Book>(
        Book(
            judul = "Harry",
            genre = "horror",
            penerbit = "Gramed",
            pengarang = "Ngarang",
            tahun = 2022,
            rangkuman = "Sehat"
        ),
        Book(
            judul = "Potter",
            genre = "Happy",
            penerbit = "Pik",
            pengarang = "GKngarang",
            tahun = 2021,
            rangkuman = "GK sehat"
        ),
    )

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UtsmobcomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Data.forEach { it ->
                            Greeting(name = it.judul)
                        }
                    }

                }
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        UtsmobcomTheme {
            Greeting("Android")
        }
    }
}