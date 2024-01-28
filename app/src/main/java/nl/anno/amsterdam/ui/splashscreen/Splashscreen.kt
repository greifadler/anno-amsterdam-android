package nl.anno.amsterdam.ui.splashscreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nl.anno.amsterdam.R
import nl.anno.amsterdam.ui.theme.AnnoandroidTheme

@Composable
fun Splashscreen() {
    AnnoandroidTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF00425A),
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // AnnoLogo
                Image(
                    painter = painterResource(id = R.drawable.annologo_weiss),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .padding(1.dp) // Adjust padding as needed
                )

                // Text "Amsterdam"
                Text(
                    text = "   Amsterdam",
                    style = TextStyle(
                        fontSize = 33.69.sp,
                        lineHeight = 50.43.sp,
                        fontFamily = FontFamily(Font(R.font.oswald)),
                        fontWeight = FontWeight(300),
                        color = Color(0xFFFF6464),
                    ),
                    modifier = Modifier
                        .width(170.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.skizze2),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .offset(y = 280.dp) // Offset the image by 250 dp on the Y-axis
                        .scale(1.2f),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SplashscreenPreview() {
    Splashscreen()
}
