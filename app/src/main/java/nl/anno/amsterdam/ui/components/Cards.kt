    package nl.anno.amsterdam.ui.components

    import androidx.compose.foundation.clickable
    import androidx.compose.foundation.layout.*
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.Close
    import androidx.compose.material3.Card
    import androidx.compose.material3.CardDefaults
    import androidx.compose.material3.Icon
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.draw.shadow
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.res.stringResource
    import androidx.compose.ui.text.TextStyle
    import androidx.compose.ui.text.font.Font
    import androidx.compose.ui.text.font.FontFamily
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import nl.anno.amsterdam.R

    @Composable
    fun BuildingPreviewCard(
        name: String,
        year: Int,
        distance: String,
        typeOfUse: String,
        onExit: () -> Unit
    ) {
        Card(
            modifier = Modifier
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x2600425A),
                    ambientColor = Color(0x2600425A)
                )
                .width(248.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(size = 5.dp)
        ) {
            Column(
                modifier = Modifier.padding(start = 16.dp, top = 24.dp, end = 16.dp, bottom = 24.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = name.uppercase(),
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 16.sp,
                            fontFamily = FontFamily(Font(R.font.oswald)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF00425A)
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(R.string.close),
                        tint = Color(0xFF00425A),
                        modifier = Modifier.clickable {
                            onExit()
                        }
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row {
                    Text(
                        text = "Anno $year",
                        style = TextStyle(
                            fontSize = 22.sp,
                            lineHeight = 22.sp,
                            fontFamily = FontFamily(Font(R.font.noto_serif)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFFA60001)
                        )
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))


                Row {
                    TransparentAnnoBadge(
                        title1 = stringResource(R.string.distance_to),
                        text1 = distance,
                        title2 = "",
                        text2 = stringResource(R.string.more_information),
                        withoutBorder = true
                    )

                }
            }
        }
    }
