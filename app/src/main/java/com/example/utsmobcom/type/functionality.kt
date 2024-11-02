package com.example.utsmobcom.type

import androidx.navigation.findNavController
import com.example.utsmobcom.type.Book
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.serialization.encodeToString
import com.example.utsmobcom.Data

fun saveBook(book: Book) {
    Data.add(book)
}

fun parseJsonToMutableList(json: String?): MutableList<Book> {
		if(json==null){
		return mutableListOf<Book>()}
    val gson = Gson()
    val listType = object : TypeToken<MutableList<Book>>() {}.type
    return gson.fromJson(json, listType)
}

fun storeNewBook(context: Context,book:Book, bookList: MutableList<Book>) {
    val sharedPreferences = context.getSharedPreferences("MyDatas", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    val gson = Gson()
    bookList.add(book)
    val json = gson.toJson(bookList)
    editor.putString("bookList", json)
    editor.apply()
}
fun loadData(context: Context, key: String): String? {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyDatas", Context.MODE_PRIVATE)
    return sharedPreferences.getString(key, null) // Returns null if key doesn’t exist
}
fun editData(){
}
fun loadAllDatas(){
}
fun getCardData(){
}











