package com.example.utsmobcom.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.navOptions
import com.example.utsmobcom.Data
import com.example.utsmobcom.type.Book

@Composable
fun BookInputPage(navController: NavController, onSave: (Book, MutableList<Book>) -> Unit) {


    var judul by remember { mutableStateOf(TextFieldValue("")) }
    var pengarang by remember { mutableStateOf(TextFieldValue("")) }
    var penerbit by remember { mutableStateOf(TextFieldValue("")) }
    var tahun by remember { mutableStateOf(TextFieldValue("")) }
    val genre by remember { mutableStateOf("") }
    var rangkuman by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Input fields with labels
        BookTextField(label = "Judul", textValue = judul, onTextChange = { judul = it })
        BookTextField(label = "Pengarang", textValue = pengarang, onTextChange = { pengarang = it })
        BookTextField(label = "Penerbit", textValue = penerbit, onTextChange = { penerbit = it })
        BookTextField(label = "Tahun", textValue = tahun, onTextChange = { tahun = it })
//        BookTextField(label = "Genre", textValue = genre, onTextChange = { genre = it })
        val genreValue = DropdownGenre(label = "Genre", currentGenre = genre)
        BookTextField(label = "Rangkuman", textValue = rangkuman, onTextChange = { rangkuman = it })

        // Row for buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                navController.navigate("home", navOptions {
                    // Pop up to "home" and remove all pages up to and including "home"
                    popUpTo("home") { inclusive = true }
                })
            }) {
                Text("Go back")
            }
            Button(onClick = {
                navController.navigate("home", navOptions {
                    // Pop up to "home" and remove all pages up to and including "home"
                    popUpTo("home") { inclusive = true }
                })
                val newBook = Book(
                    judul = judul.text,
                    pengarang = pengarang.text,
                    penerbit = penerbit.text,
                    tahun = tahun.text,
                    genre = genreValue,
                    rangkuman = rangkuman.text
                )
                onSave(newBook, Data)
            }) {
                Text("Add book")
            }
        }
    }
}

@Composable
fun BookTextField(
    label: String,
    textValue: TextFieldValue,
    onTextChange: (TextFieldValue) -> Unit
) {
    Column {
        Text(text = label, style = MaterialTheme.typography.labelMedium)
        TextField(
            value = textValue,
            onValueChange = onTextChange,
            modifier = Modifier.fillMaxWidth()

        )
    }
}

@Composable
fun DropdownGenre(
    label: String,
    currentGenre: String
): String {

    val isDropDownExpanded = remember {
        mutableStateOf(false)
    }
    val genres = listOf("Romansa", "Misteri", "Fantasi", "Petualangan")

    var itemPosition = remember {
        mutableStateOf(0)
    }
    if (genres.indexOf(currentGenre) != -1) {
        itemPosition = remember {
            mutableStateOf(genres.indexOf(currentGenre))
        }
    }


    Box {
        Column {
            Text(text = label, style = MaterialTheme.typography.labelMedium)
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable {
                        isDropDownExpanded.value = true
                    }
                    .fillMaxWidth()
            ) {
                Text(text = genres[itemPosition.value])
                Icon(
                    Icons.Filled.ArrowDropDown,
                    "DropDown Icon"
                )
            }
            DropdownMenu(
                expanded = isDropDownExpanded.value,
                onDismissRequest = {
                    isDropDownExpanded.value = false
                },
                modifier = Modifier.fillMaxWidth()
            ) {

                genres.forEachIndexed { index, genre ->
                    DropdownMenuItem(
                        text = { Text(text = genre) },
                        onClick = {
                            isDropDownExpanded.value = false
                            itemPosition.value = index
                        },
                    )
                }

            }
        }
    }
    return genres[itemPosition.value]
}


@Composable
fun BookEditPage(
    navController: NavController,
    onSave: (Book, MutableList<Book>, Int) -> Unit,
    deleteABook: (Book, MutableList<Book>) -> Unit,
    idBook: Int,
    book: Book
) {
    // State variables to hold text input for each field
    var judul by remember { mutableStateOf(TextFieldValue(book.judul)) }
    var pengarang by remember { mutableStateOf(TextFieldValue(book.pengarang)) }
    var penerbit by remember { mutableStateOf(TextFieldValue(book.penerbit)) }
    var tahun by remember { mutableStateOf(TextFieldValue(book.tahun)) }
    val genre by remember { mutableStateOf((book.genre)) }
    var rangkuman by remember { mutableStateOf(TextFieldValue(book.rangkuman)) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        BookTextField(label = "Judul", textValue = judul, onTextChange = { judul = it })
        BookTextField(label = "Pengarang", textValue = pengarang, onTextChange = { pengarang = it })
        BookTextField(label = "Penerbit", textValue = penerbit, onTextChange = { penerbit = it })
        BookTextField(label = "Tahun", textValue = tahun, onTextChange = { tahun = it })
//        BookTextField(label = "Genre", textValue = genre, onTextChange = { genre = it })
        val genreValue = DropdownGenre(label = "Genre", currentGenre = genre)
        BookTextField(label = "Rangkuman", textValue = rangkuman, onTextChange = { rangkuman = it })

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    navController.navigate("home", navOptions {
                        popUpTo("home") {
                            inclusive = true
                        }
                    })
                }
            ) {
                Text("Go Back")
            }
            Button(
                onClick = {
                    deleteABook(book, Data)
                    navController.navigate("home", navOptions {
                        popUpTo("home") {
                            inclusive = true
                        }
                    })
                }
            ) {
                Text(
                    "Delete",
                    )
            }
            Button(
                onClick = {
                    navController.navigate("home", navOptions {
                        popUpTo("home") {
                            inclusive = true
                        }
                    })

                    val newBook = Book(
                        judul = judul.text,
                        pengarang = pengarang.text,
                        penerbit = penerbit.text,
                        tahun = tahun.text,
                        genre = genreValue,
                        rangkuman = rangkuman.text
                    )
                    onSave(newBook, Data, idBook)
                }
            ) {
                Text("Save Edit")
            }
        }
    }
}
