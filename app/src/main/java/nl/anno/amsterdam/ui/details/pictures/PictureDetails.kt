package nl.anno.amsterdam.ui.details.pictures

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nl.anno.amsterdam.R
import nl.anno.amsterdam.data.demoBuildingData
import nl.anno.amsterdam.ui.theme.AnnoandroidTheme
import nl.anno.amsterdam.data.LocalImage
import nl.anno.amsterdam.ui.components.AnnoImage
import nl.anno.amsterdam.ui.details.DetailsViewModel
import nl.anno.amsterdam.ui.theme.AnnoBlueLight


@Composable
fun ImageScreen(
    img: LocalImage,
    viewModel: DetailsViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(horizontalArrangement = Arrangement.End) {
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    Icons.Outlined.Close,
                    contentDescription = stringResource(R.string.close_2),
                    modifier = Modifier
                        .clickable {
                            viewModel.setSelectedImage(null)
                        }
                        .padding(12.dp))
            }
            Spacer(modifier = Modifier.height(10.dp))
            Divider(
                color = AnnoBlueLight,
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Image
            AnnoImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(0.dp, 450.dp),
                imageLink = img.url,
                contentDescription = img.source
            )
            Spacer(modifier = Modifier.height(20.dp))

            // Year
            Text(
                text = "Anno ${img.year}",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(Font(R.font.noto_serif)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFFA60001),
                ),
                modifier = Modifier
                    .padding(top = 4.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Description
            Text(
                text = img.source,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(Font(R.font.noto_serif)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF00425A),
                ),
                modifier = Modifier
                    .padding(top = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PictureDetailsPreview() {
    AnnoandroidTheme {
        val building = demoBuildingData()[0] // Use a building from your demo data
        ImageScreen(img = building.mainLocalImageLink)
    }
}

