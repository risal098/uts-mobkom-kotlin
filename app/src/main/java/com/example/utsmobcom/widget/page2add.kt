package com.example.utsmobcom.widget
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.utsmobcom.type.Book
import android.content.Context
import com.example.utsmobcom.Data
@Composable
fun BookInputPage(navController: NavController,onSave: (Book,MutableList<Book>) -> Unit) {
    // State variables to hold text input for each field
    var judul by remember { mutableStateOf(TextFieldValue("")) }
    var pengarang by remember { mutableStateOf(TextFieldValue("")) }
    var penerbit by remember { mutableStateOf(TextFieldValue("")) }
    var tahun by remember { mutableStateOf(TextFieldValue("")) }
    var genre by remember { mutableStateOf(TextFieldValue("")) }
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
        BookTextField(label = "Genre", textValue = genre, onTextChange = { genre = it })
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
                Text("Left Button")
            }
            Button(onClick = {
                navController.navigate("home", navOptions {
                    // Pop up to "home" and remove all pages up to and including "home"
                    popUpTo("home") { inclusive = true }
                })
                var newBook=Book(
                judul = judul.text,
                pengarang = pengarang.text,
                penerbit = penerbit.text,
                tahun = tahun.text,
                genre = genre.text,
                rangkuman = rangkuman.text
            )
            onSave(newBook,Data)
            }) {
                Text("Right Button")
            }
        }
    }
}

@Composable
fun BookTextField(label: String, textValue: TextFieldValue, onTextChange: (TextFieldValue) -> Unit) {
    Column {
        Text(text = label, style = MaterialTheme.typography.labelMedium)
        TextField(
            value = textValue,
            onValueChange = onTextChange,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
