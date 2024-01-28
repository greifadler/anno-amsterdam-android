package nl.anno.amsterdam.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nl.anno.amsterdam.R


@Composable
fun AnnoButtonOutlined(onclick: () -> Unit, content: @Composable() () -> Unit, color: Color = Color.White) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(size = 5.dp))
            .background(color)
            .border(
                width = 1.dp,
                color = Color(0xFFC5D9E0),
                shape = RoundedCornerShape(size = 5.dp)
            )
            .clickable {
                onclick()
            }
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        content()
    }
}
@Composable
fun AnnoButton(onclick: () -> Unit, content: @Composable() () -> Unit) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .background(color = Color(0xFFA60001))
            .clickable { onclick() }

        ,
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            content()
        }
    }
}


@Composable
fun AnnoButtonOutlined(onclick: () -> Unit, text: String? = null, icon: ImageVector? = null) {
    AnnoButtonOutlined(onclick = { onclick() }, content = {
        icon?.let {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color(0xFF073854)
            )
        }

        text?.let {
            Text(
                text = it,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                        fontFamily = FontFamily(Font(R.font.oswald)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF073854)
                ),
                modifier = Modifier.padding(start = 4.dp, end = 4.dp)
            )
        }

    })
}

@Composable
fun AnnoNext(onClick: () -> Unit, text: String? = null) {
    Button(
        onClick = { onClick() }, // Action for the button click
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent), // Set button background color
        contentPadding = PaddingValues(), // Remove default padding inside the button
        modifier = Modifier
            .padding(10.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFFF6464),
                shape = RoundedCornerShape(5.dp)
            )
            .width(84.dp)
            .height(39.dp)
    ) {
        Text(
            text = text ?: stringResource(R.string.next), // Standard text if no text is provided
            style = TextStyle(
                fontSize = 17.sp,
                lineHeight = 17.sp,
                fontFamily = FontFamily(Font(R.font.oswald)),
                fontWeight = FontWeight(500),
                color = Color.White
            )
        )
    }
}



@Composable
fun SkipButton(onclick: () -> Unit, text: String? = null) {
    Button(
        onClick = { onclick() }, // Action to perform when the button is clicked
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent), // Set the background color
        contentPadding = PaddingValues(start = 4.dp, end = 4.dp), // Padding inside the button
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp, pressedElevation = 0.dp), // Remove elevation to make it look flat
    ) {
        Text(
            text = text ?: stringResource(R.string.skip), // Text to display in the button
            style = TextStyle(
                fontSize = 17.sp,
                lineHeight = 17.sp,
                fontFamily = FontFamily(Font(R.font.oswald)),
                fontWeight = FontWeight(500),
                color = Color(0xFFFFFFFF)
            )
        )
    }
}


