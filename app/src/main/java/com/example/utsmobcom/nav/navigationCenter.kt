package com.example.utsmobcom.nav

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.utsmobcom.Data
import com.example.utsmobcom.type.deleteBook
import com.example.utsmobcom.type.editBook
import com.example.utsmobcom.type.storeNewBook
import com.example.utsmobcom.widget.BookEditPage
import com.example.utsmobcom.widget.BookInputPage
import com.example.utsmobcom.widget.ShowBook
import com.example.utsmobcom.widget.showMainPage

@Composable
fun navCenter(context: Context) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { showMainPage(navController, context) }
        composable("add_book") {
            BookInputPage(navController) { book, bookList ->
                storeNewBook(
                    context, book, bookList
                )
            }
        }
        composable("edit_book/{id}") { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getString("id")
            id?.let { bookId ->
                bookId.toIntOrNull()?.let {
                    BookEditPage(
                        navController,
                        { book, bookList, id -> editBook(context, book, bookList, id) },
                        {  bookList,id -> deleteBook(context,  bookList,id) },
                        it,
                        Data[it]
                    )
                }
            }
        }
        composable("show_book/{id}") { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getString("id")
            id?.let { bookId ->
                bookId.toIntOrNull()?.let { ShowBook(navController, it) }
            }
        }

    }
}
