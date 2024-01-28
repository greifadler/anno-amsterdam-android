import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import nl.anno.amsterdam.MainViewModel
import nl.anno.amsterdam.R
import nl.anno.amsterdam.Screen
import nl.anno.amsterdam.data.demoBuildingData
import nl.anno.amsterdam.ui.components.AnnoImage
import nl.anno.amsterdam.ui.components.AnnoSearchBar
import nl.anno.amsterdam.ui.components.CenturyFilter
import nl.anno.amsterdam.ui.details.DetailsViewModel

@Composable
fun infos(title1: String, text1: String, title2: String, text2: String) {
    Row(
        modifier = Modifier
            .padding(start = 1.dp, top = 10.dp, end = 20.dp, bottom = 10.dp)
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
                    lineHeight = 22.4.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF00425A),
                )
            )
        }
        Divider(
            modifier = Modifier
                .height(60.dp)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navController: NavController,
    viewModel: MainViewModel,
    detailsViewModel: DetailsViewModel
) {
    val positions = viewModel.buildings.collectAsState().value

    Column {
        Spacer(modifier = Modifier.height(8.dp))
        AnnoSearchBar(viewModel = viewModel)
        Spacer(modifier = Modifier.height(8.dp))
        CenturyFilter(viewModel = viewModel)

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            items(positions) { building ->
                ListItem(
                    streetName = building.name,
                    buildingYear = "Anno ${building.year}",
                    imageLink = building.mainLocalImageLink.url,
                    typeOfUse = building.typeOfUse,
                    onClick = {
                        detailsViewModel.setBuilding(building)
                        navController.navigate(
                            Screen.DETAILS.route
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun ListItem(
    streetName: String,
    buildingYear: String,
    imageLink: String,
    typeOfUse: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Display the image using the Image composable
        AnnoImage(
            modifier = Modifier
                .width(110.dp)
                .height(140.dp)
                .padding(end = 16.dp),
            imageLink = imageLink,
            contentDescription = stringResource(R.string.main_img_alt)
        )

        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = streetName,
                modifier = Modifier
                    .height(24.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Font(R.font.oswald)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF00425A),
                )
            )
            Text(
                text = buildingYear,
                modifier = Modifier
                    .height(30.dp),
                style = TextStyle(
                    fontSize = 22.sp,
                    lineHeight = 22.sp,
                    fontFamily = FontFamily(Font(R.font.oswald)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFFA60001),
                )
            )
            infos(
                title1 = "Distance to",
                text1 = "3m",
                title2 = "Type of use",
                text2 = typeOfUse
            )
            Divider(
                modifier = Modifier
                    .offset(x = 0.dp, y = 8.500.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = Color(0xFFC5D9E0))
            )
        }
    }
}



