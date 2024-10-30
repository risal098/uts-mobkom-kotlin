package com.example.utsmobcom.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.utsmobcom.ui.theme.UtsmobcomTheme
import com.example.utsmobcom.type.Book
import com.example.utsmobcom.Data

@Composable
fun ShowBox(book: Book) {
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



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UtsmobcomTheme {
        ShowBox(Data[1])
    }
}