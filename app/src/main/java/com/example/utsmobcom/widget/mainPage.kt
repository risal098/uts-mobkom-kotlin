package com.example.utsmobcom.widget

import android.content.Context
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import com.example.utsmobcom.Data
import com.example.utsmobcom.type.Book
import com.example.utsmobcom.type.loadData
import com.example.utsmobcom.type.parseJsonToMutableList

@Composable
fun showMainPage(navController: NavController, context: Context) {
    var dataBook by remember { mutableStateOf(emptyList<Book>()) }
    LaunchedEffect(Unit) {
        Data = parseJsonToMutableList(loadData(context, "bookList"))
        dataBook = Data
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
                if (dataBook.isEmpty()) {
                    Text(text = "No Data Available")

                } else {
                    dataBook.forEach { item ->
                        ShowBox(navController, item)
                    }
                }
            }

            Button(
                onClick = { navController.navigate("add_book") },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
            ) {
                Icon(Icons.Filled.Add, "Add Button")
                Text("Add Book")
            }
        }
    }
}


@Composable
fun ShowBox(navController: NavController, book: Book) {

    val id = if (Data.size != 0) Data.indexOf(book) else 0
    if (Data.size == 0) {
        Text(text = "No Data Available")
        return
    }

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
        Row(
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
                Button(
                    onClick = {
                        navController.navigate(
                            "edit_book/{id}".replace(
                                "{id}",
                                id.toString()
                            )
                        )
                    },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(8.dp)
                ) {
                    Text("Edit")
                }
            }

        }


    }
}



