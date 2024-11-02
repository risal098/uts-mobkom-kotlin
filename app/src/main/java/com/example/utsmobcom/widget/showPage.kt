package com.example.utsmobcom.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.utsmobcom.Data
import com.example.utsmobcom.type.Book
@Composable
fun ShowBook(navController: NavController, book: Int) {

    Box {
        Column(
            modifier = Modifier
                .fillMaxHeight()
        )
        {
            ShowBoxFull(navController = navController, book = Data[book])
        }
        ExtendedFloatingActionButton (

            interactionSource = remember {
                MutableInteractionSource()
            },
            onClick = {
                      navController.popBackStack()
                      },
            containerColor = Color(175, 123, 189),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
        ) {
            Row (
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                Text(
                    text = "Go Back",
                    modifier = Modifier.padding(start = 12.dp)
                    )
            }
        }
    }

}

@Composable
fun ShowBoxFull(navController: NavController, book: Book) {
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

    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Column {
                Column (
                    modifier = Modifier.padding(bottom = 12.dp)
                ){
                    Text(text = "Judul: ")
                    Text(
                        text = book.judul,
                        modifier = Modifier
                            .background(
                                color = Color(213, 213, 207),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(8.dp, 12.dp, 8.dp, 12.dp)
                            .fillMaxWidth()
                    )
                }
                Column (
                    modifier = Modifier.padding(bottom = 12.dp)
                ){
                    Text(text = "Judul: ")
                    Text(
                        text = book.judul,
                        modifier = Modifier
                            .background(
                                color = Color(213, 213, 207),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(8.dp, 12.dp, 8.dp, 12.dp)
                            .fillMaxWidth()
                    )
                }
                Column (
                    modifier = Modifier.padding(bottom = 12.dp)
                ){
                    Text(text = "Penerbit: ")
                    Text(
                        text = book.penerbit,
                        modifier = Modifier
                            .background(
                                color = Color(213, 213, 207),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(8.dp, 12.dp, 8.dp, 12.dp)
                            .fillMaxWidth()
                    )
                }
                Column (
                    modifier = Modifier.padding(bottom = 12.dp)
                ){
                    Text(text = "Pengarang: ")
                    Text(
                        text = book.pengarang,
                        modifier = Modifier
                            .background(
                                color = Color(213, 213, 207),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(8.dp, 12.dp, 8.dp, 12.dp)
                            .fillMaxWidth()
                    )
                }
                Column (
                    modifier = Modifier.padding(bottom = 12.dp)
                ){
                    Text(text = "Tahun: ")
                    Text(
                        text = book.tahun,
                        modifier = Modifier
                            .background(
                                color = Color(213, 213, 207),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(8.dp, 12.dp, 8.dp, 12.dp)
                            .fillMaxWidth()
                    )
                }
                Column (
                    modifier = Modifier.padding(bottom = 12.dp)
                ){
                    Text(text = "Genre: ")
                    Text(
                        text = book.genre,
                        modifier = Modifier
                            .background(
                                color = Color(213, 213, 207),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(8.dp, 12.dp, 8.dp, 12.dp)
                            .fillMaxWidth()
                    )
                }
                Column (
                    modifier = Modifier.padding(bottom = 12.dp)
                ){
                    Text(text = "Rangkuman: ")
                    Text(
                        text = book.rangkuman,
                        modifier = Modifier
                            .background(
                                color = Color(213, 213, 207),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(8.dp, 12.dp, 8.dp, 12.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }


    }
}



