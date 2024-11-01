package com.example.utsmobcom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.utsmobcom.ui.theme.UtsmobcomTheme
import com.example.utsmobcom.widget.ShowBox
import com.example.utsmobcom.type.Book
import com.example.utsmobcom.widget.showMainPage
import com.example.utsmobcom.nav.navCenter
val Data = mutableListOf<Book>(
        Book(
            judul = "aaaHarry",
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
        Book(
            judul = "Potter",
            genre = "Happy",
            penerbit = "Pik",
            pengarang = "GKngarang",
            tahun = 2021,
            rangkuman = "GK sehat"
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
               navCenter()
            }
        }
    }
}
