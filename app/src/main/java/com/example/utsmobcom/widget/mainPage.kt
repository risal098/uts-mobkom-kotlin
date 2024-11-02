package com.example.utsmobcom.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.utsmobcom.type.Book

var testing=Book(
            judul = "testing",
            genre = "Happy",
            penerbit = "Pik",
            pengarang = "GKngarang",
            tahun = 2021,
            rangkuman = "GK sehat"
        )
var testing2=Book(
            judul = "tiosting",
            genre = "Happy",
            penerbit = "Pik",
            pengarang = "GKngarang",
            tahun = 2021,
            rangkuman = "GK sehat"
        )
var testing3=Book(
            judul = "hosting",
            genre = "Happy",
            penerbit = "Pik",
            pengarang = "GKngarang",
            tahun = 2021,
            rangkuman = "GK sehat"
        )
var Data = mutableListOf<Book>(
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
fun storeInput(testing:Book,Datas:MutableList<Book>):MutableList<Book>{

    Datas.add(testing)
    return (Datas)
}
@Composable
fun showMainPage(navController: NavController) {
var data by remember { mutableStateOf(emptyList<Book>()) }
LaunchedEffect(Unit) {
        data = storeInput(testing,Data) // Fetch and set data from storeInput
      //  data = data.toMutableList()
      //  Data.add(testing2)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                data.forEach { item ->
                    ShowBox(navController, item)
                }
            }
            
            // Button fixed to the bottom right corner
            Button(
                onClick = { navController.navigate("add_book") },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp) // Padding around the button
            ) {
                Text("Fixed Button")
            }
        }
    }
}



@Composable
fun ShowBox(navController: NavController, book: Book) {
    val id = Data.indexOf(book)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                top = 10.dp,
                bottom = 10.dp,
                end = 16.dp,
                start = 16.dp
            )
            .clickable {
                navController.navigate("show_book/{id}".replace("{id}", id.toString()))
            }

    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Column {
                Text(text = "Judul: " + book.judul)
                Text(text = "Penerbit: " + book.penerbit)
            }
            Box(
                modifier = Modifier
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(16.dp)
                        )
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .padding(
                        all = 10.dp
                    )
                    .clip(RoundedCornerShape(20.dp))
            ) {
                Text(text = "Edit")
            }

        }


    }
}



