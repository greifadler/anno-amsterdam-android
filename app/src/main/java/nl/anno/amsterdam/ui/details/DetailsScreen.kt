package nl.anno.amsterdam.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import nl.anno.amsterdam.R
import nl.anno.amsterdam.ui.components.AnnoBadge
import nl.anno.amsterdam.ui.components.AnnoButtonOutlined
import nl.anno.amsterdam.ui.components.AnnoImage
import nl.anno.amsterdam.ui.components.SmallBadge
import nl.anno.amsterdam.ui.components.TransparentAnnoBadge
import nl.anno.amsterdam.ui.details.pictures.ImageScreen
import nl.anno.amsterdam.ui.theme.AnnoandroidTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DetailsScreen(
    navController: NavController,
    viewModel: DetailsViewModel
) {
    val slimBuilidng = viewModel.localBuilding.collectAsState().value
//    val building =
//        demoBuildingData().firstOrNull() { it.id == buildingId } ?: demoBuildingData().first()
    val selectedImage = viewModel.selectedLocalImage.collectAsState().value

    if (slimBuilidng == null) {
        Text(stringResource(R.string.building_not_found))


    } else {


        if (selectedImage != null) {
            ImageScreen(img = selectedImage, viewModel = viewModel)
        } else {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
            ) {
                item {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(240.dp)
                    ) {

                        AnnoImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(240.dp)
                                .clickable { viewModel.setSelectedImage(slimBuilidng.mainLocalImageLink) },
                            imageLink = slimBuilidng.mainLocalImageLink.url,
                            contentDescription = stringResource(R.string.main_img_alt)
                        )
                        TopNavWithBackBtn(navController = navController)
                        Box(modifier = Modifier.offset(x = 20.dp, y = 210.dp)) {
                            AnnoBadge(text = "Anno ${slimBuilidng.year}")
                        }
                    }
                    Column(
                        Modifier.padding(
                            start = 20.dp,
                            top = 40.dp,
                            end = 20.dp,
                            bottom = 20.dp
                        )
                    ) {
                        Text(
                            text = slimBuilidng.name.uppercase(),
                            style = TextStyle(
                                fontSize = 30.sp,
                                lineHeight = 30.sp,
                                fontFamily = FontFamily(Font(R.font.oswald)),

                                fontWeight = FontWeight(400),
                                color = Color(0xFF00425A),
                            )
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        TransparentAnnoBadge(
                            title1 = stringResource(R.string.distance_to_2),
                            text1 = "5m",
                            title2 = stringResource(R.string.type_of_use),
                            text2 = slimBuilidng.typeOfUse
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        FlowRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            slimBuilidng.artefacts.forEach { artefact ->
                                SmallBadge(text = artefact)
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = slimBuilidng.description,
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 25.6.sp,
                                fontFamily = FontFamily(Font(R.font.noto_serif)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF00425A),
                            )
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        item {
                            Spacer(modifier = Modifier.width(20.dp))
                        }
                        items(slimBuilidng.localImageLinks) { imageLink ->
                            AnnoImage(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(260.dp)
                                    .widthIn(0.dp, 260.dp)
                                    .clickable { viewModel.setSelectedImage(imageLink) },
                                imageLink = imageLink.url,
                                contentDescription = stringResource(R.string.main_img_alt)
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.width(20.dp))
                        }
                    }
                    Column(
                        Modifier.padding(
                            start = 20.dp,
                            top = 40.dp,
                            end = 20.dp,
                            bottom = 20.dp
                        )
                    ) {
                        Text(
                            text = stringResource(R.string.details_timeline_title),
                            style = TextStyle(
                                fontSize = 22.sp,
                                lineHeight = 22.sp,
                                fontFamily = FontFamily(Font(R.font.oswald)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF00425A),
                            )
                        )
                        slimBuilidng.localTimeline.forEach { timelineElement ->
                            TimelineRow(
                                year = "${timelineElement.year}",
                                text = timelineElement.text
                            )
                        }
//                LazyColumn {
//                    items(building.timeline) { timelineElement ->
//                        TimelineRow(year = "${timelineElement.year}", text = timelineElement.text)
//                    }
//                }
                    }
                }
            }

        }
    }
}


@Composable
fun TimelineRow(year: String, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp)
    ) {
        Text(
            text = year,
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 18.sp,
                fontFamily = FontFamily(Font(R.font.noto_serif)),
                fontWeight = FontWeight.W700,
                color = Color(0xFFA60001),
                textAlign = TextAlign.Right,
            ),
            modifier = Modifier.width(50.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier.fillMaxHeight()
        ) {
//            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Outlined.Circle,
                contentDescription = null,
                modifier = Modifier
                    .size(9.dp),
                tint = Color(0xFF00425A)
            )
//            Spacer(modifier = Modifier.weight(1f))

        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 18.sp,
                fontFamily = FontFamily(Font(R.font.noto_serif)),
                fontWeight = FontWeight.Normal,
                color = Color(0xFF00425A),
            ),
            modifier = Modifier
                .weight(1f)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavWithBackBtn(navController: NavController) {
    Row(Modifier.padding(20.dp)) {
        AnnoButtonOutlined(
            onclick = { navController.popBackStack() },
            icon = Icons.Default.KeyboardArrowLeft,
            text = stringResource(R.string.back)
        )
        Spacer(modifier = Modifier.weight(1f))
        AnnoButtonOutlined(
            onclick = { navController.popBackStack() },
            icon = Icons.Default.MoreVert
        )
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
    AnnoandroidTheme {
        val navController = rememberNavController()
        DetailsScreen(navController = navController, viewModel())
    }
}
