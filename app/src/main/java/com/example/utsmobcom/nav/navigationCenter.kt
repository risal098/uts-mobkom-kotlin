package com.example.utsmobcom.nav
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.utsmobcom.widget.BookInputPage
import com.example.utsmobcom.widget.showMainPage
@Composable
fun navCenter() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { showMainPage(navController) }
        composable("add_book") { BookInputPage(navController) }
       
    }
}
