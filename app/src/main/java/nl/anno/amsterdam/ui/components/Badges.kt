package nl.anno.amsterdam.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nl.anno.amsterdam.R

@Composable
fun AnnoBadge(text: String) {
    Box(
        modifier = Modifier

//            .height(44.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(color = Color(0xFFA60001)),
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontFamily = FontFamily(Font(R.font.noto_serif)),
                    fontWeight = FontWeight.W600,
                    fontSize = 24.sp,
                    lineHeight = 24.sp,
                ),
                color = Color.White
            )
        }
    }
}


@Composable
fun TransparentAnnoBadge(
    title1: String,
    text1: String,
    title2: String,
    text2: String,
    withoutBorder: Boolean = false
) {
    Box(
        modifier = if (withoutBorder) Modifier else Modifier
            .border(
                width = 1.dp,
                color = Color(0xFFC5D9E0),
                shape = RoundedCornerShape(5.dp)
            )
            .fillMaxWidth()
    ) {
        Row(
            modifier = if (withoutBorder) Modifier else Modifier
                .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 10.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = title1,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontFamily = FontFamily(Font(R.font.noto_serif)),
                        fontWeight = FontWeight.W500,
                        fontSize = 12.sp,
                        lineHeight = 12.sp,
                        color = Color(0x8000425A),
                    )
                )
                Text(
                    text = text1,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontFamily = FontFamily(Font(R.font.noto_serif)),
                        fontSize = 16.sp,
                        lineHeight = 22.4.sp, fontWeight = FontWeight.Normal,
                        color = Color(0xFF00425A),
                    )
                )
            }
            Divider(
                modifier = Modifier
                    .height(36.dp)
                    .width(17.dp)
                    .padding(horizontal = 8.dp),
                color = Color(0xFFC5D9E0),
                thickness = 1.dp
            )
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = title2,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontFamily = FontFamily(Font(R.font.noto_serif)),
                        fontWeight = FontWeight.W500,
                        fontSize = 12.sp,
                        lineHeight = 12.sp,
                        color = Color(0x8000425A),
                    )
                )
                Text(
                    text = text2,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontFamily = FontFamily(Font(R.font.noto_serif)),
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        lineHeight = 22.4.sp,
                        color = Color(0xFF00425A),
                    )
                )
            }
        }
    }
}

@Composable
fun SmallBadge(text: String) {
    Box(
        modifier = Modifier
            .border(width = 1.dp, color = Color(0xFFC5D9E0), shape = RoundedCornerShape(5.dp))
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 10.dp, top = 3.dp, end = 10.dp, bottom = 3.dp)
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 14.sp,
                    lineHeight = 19.6.sp,
                    fontFamily = FontFamily(Font(R.font.noto_serif)),
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF00425A),
                )
            )
        }
    }
}
