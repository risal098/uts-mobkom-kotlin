package com.example.utsmobcom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.utsmobcom.nav.navCenter
import com.example.utsmobcom.type.Book
import com.example.utsmobcom.ui.theme.UtsmobcomTheme

var Data=mutableListOf<Book>() 

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UtsmobcomTheme {
               navCenter(context=this)
            }
        }
    }
}
