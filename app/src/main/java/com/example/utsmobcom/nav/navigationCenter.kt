package com.example.utsmobcom.nav
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.utsmobcom.widget.BookInputPage
import com.example.utsmobcom.widget.ShowBook
import com.example.utsmobcom.widget.showMainPage

@Composable
fun navCenter() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { showMainPage(navController) }
        composable("add_book") { BookInputPage(navController) }
        composable("show_book/{id}") {
            navBackStackEntry ->
                val id = navBackStackEntry.arguments?.getString("id")
                id?.let {
                    bookId ->
                    bookId.toIntOrNull()?.let { ShowBook(navController, it) }
                }
        }
       
    }
}
