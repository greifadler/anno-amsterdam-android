package nl.anno.amsterdam.ui.map

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getDrawable
import androidx.core.content.ContextCompat.getString
import androidx.core.graphics.drawable.toBitmap
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.MarkerInfoWindow
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.launch
import nl.anno.amsterdam.MainViewModel
import nl.anno.amsterdam.R
import nl.anno.amsterdam.Screen
import nl.anno.amsterdam.ui.components.AnnoButton
import nl.anno.amsterdam.ui.components.AnnoSearchBar
import nl.anno.amsterdam.ui.components.BuildingPreviewCard
import nl.anno.amsterdam.ui.components.CenturyFilter
import nl.anno.amsterdam.ui.details.DetailsViewModel
import nl.anno.amsterdam.ui.theme.AnnoRed


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MapScreen(
    navController: NavController,
    viewModel: MainViewModel,
    detailsViewModel: DetailsViewModel,

    ) {

    val locationPermissionState = rememberPermissionState(
        android.Manifest.permission.ACCESS_FINE_LOCATION
    )

    if (locationPermissionState.status.isGranted) {
        Box {
            MapScreenContent(navController, viewModel, detailsViewModel)

        }
    } else {
        Column {
            val textToShow = if (locationPermissionState.status.shouldShowRationale) {
                stringResource(R.string.your_location_is_important_for_this_app_please_grant_the_permission)
            } else {
                // If it's the first time the user lands on this feature, or the user
                // doesn't want to be asked again for this permission, explain that the
                // permission is required
                stringResource(R.string.your_location_is_required_for_this_feature_to_be_available) +
                        "Please grant the permission"
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    textToShow,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.noto_serif)),
                )
                Spacer(modifier = Modifier.height(16.dp))
                Icon(
                    imageVector = Icons.Outlined.Map,
                    contentDescription = null,
                    tint = AnnoRed,
                    modifier = Modifier.size(100.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                AnnoButton(onclick = { locationPermissionState.launchPermissionRequest() }) {
                    Text(
                        stringResource(R.string.request_permission).uppercase(),
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontFamily = FontFamily(Font(R.font.noto_serif)),
                            fontWeight = FontWeight.W600,
                            fontSize = 18.sp,
                            lineHeight = 18.sp,
                        ),
                        color = Color.White
                    )

                }
            }


        }
    }


}
@Composable
fun MapScreenContent(
    navController: NavController,
    viewModel: MainViewModel,
    detailsViewModel: DetailsViewModel
) {
    val positions = viewModel.buildings.collectAsState().value
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(
            if (positions.isNotEmpty()) positions.first().convertToLatLng()
            else LatLng(52.377956, 4.897070),
            14f
        )

    }

    val coroutineScope = rememberCoroutineScope()

    var searchText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Karte
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            googleMapOptionsFactory = {
                GoogleMapOptions().mapId(
                    getString(
                        navController.context,
                        R.string.map_id
                    )
                )
            },
            uiSettings = MapUiSettings(),

            properties = MapProperties(
                isMyLocationEnabled = true,
                latLngBoundsForCameraTarget = LatLngBounds(
                    LatLng(52.27732, 4.52693),
                    LatLng(52.43312, 5.07097)
                ),
                minZoomPreference = 11f,
                mapStyleOptions = annoMapStyleOptions
            )

        ) {
            positions.forEach { building ->
                MarkerInfoWindow(
                    state = MarkerState(position = building.convertToLatLng()),
                    icon = BitmapDescriptorFactory.fromBitmap(
                        getDrawable(
                            LocalContext.current,
                            R.drawable.marker_blue
                        )!!.toBitmap(60, 90)
                    ),
                    onInfoWindowClick = {
                        coroutineScope.launch {
                            detailsViewModel.setBuilding(building)
                            navController.navigate(Screen.DETAILS.route)
                        }
                    }

                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                    ) {
                        BuildingPreviewCard(
                            name = building.name,
                            year = building.year,
                            distance = "5m",
                            typeOfUse = building.typeOfUse
                        ) {
                            coroutineScope.launch() {
                                it.hideInfoWindow()
                            }
                        }
                        Icon(
                            painter = painterResource(id = R.drawable.triangle),
                            contentDescription = null,
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.height(7.dp))
                    }
                }
            }
        }

        // AnnoSearchBar und CenturyFilter werden über die Karte gelegt
        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            AnnoSearchBar(viewModel = viewModel)
            Spacer(modifier = Modifier.height(8.dp))
            CenturyFilter(viewModel = viewModel)
        }
    }
}
