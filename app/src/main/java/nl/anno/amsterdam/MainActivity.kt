package nl.anno.amsterdam

import ListScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import nl.anno.amsterdam.data.preferences.AppPreferences
import nl.anno.amsterdam.ui.details.DetailsScreen
import nl.anno.amsterdam.ui.details.DetailsViewModel
import nl.anno.amsterdam.ui.map.MapScreen
import nl.anno.amsterdam.ui.onboarding.Onboarding

import nl.anno.amsterdam.ui.theme.AnnoBlue
import nl.anno.amsterdam.ui.theme.AnnoRed
import nl.anno.amsterdam.ui.theme.AnnoandroidTheme


enum class Screen(val route: String, val resourceId: Int = 0, val icon: ImageVector) {
    MAP("map", R.string.map, Icons.Outlined.Map),
    LIST("list", R.string.list, Icons.Outlined.List),
    LENS("lens", R.string.lens, Icons.Outlined.CameraAlt),
    DETAILS("details", R.string.details, Icons.Filled.Favorite),
    ACCOUNT("account", R.string.account, Icons.Filled.AccountCircle);
}

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        val appPrefs = AppPreferences(applicationContext)

        super.onCreate(savedInstanceState)
        setContent {

            val viewModel: MainViewModel = viewModel()
            val detailsViewModel: DetailsViewModel = viewModel()
            AnnoandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val items = mutableListOf(
                        Screen.MAP,
                       // Screen.LENS,
                        Screen.LIST
                    )

                    var selectedItem by remember { mutableStateOf(Screen.MAP) }

                    val isFirstTime = appPrefs.isFirstTimeFlow.collectAsState().value

                    if (isFirstTime) {
                        Onboarding {
                            appPrefs.setOnboardingDone()
                        }
                    } else {

                        val navController = rememberNavController()
                        Scaffold(
                            topBar = {
                                Box(
                                    modifier = Modifier.border(
                                        width = 1.dp,
                                       color = Color(0xFFC5D9E0)
                                    )
                                ) {
                                    TopAppBar(
                                        title = {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.annologo_blue),
                                                    contentDescription = "Anno",
                                                    modifier = Modifier
                                                        .height(20.dp)
                                                        .width(90.dp)
                                                )
                                                Spacer(modifier = Modifier.width(8.dp))
                                                Text(
                                                    text = "Amsterdam".uppercase(),
                                                    style = TextStyle(
                                                        fontSize = 22.sp,
                                                        lineHeight = 26.4.sp,
                                                        fontFamily = FontFamily(Font(R.font.oswald)),
                                                        fontWeight = FontWeight(300),
                                                        color = AnnoRed,
                                                    )
                                                )
                                            }
                                        },
                                        actions = {
                                            // Add an IconButton with a refresh icon
                                            IconButton(onClick = { viewModel.fetchBuildings(null,null) }) {
                                                Icon(
                                                    imageVector = Icons.Filled.Refresh,
                                                    contentDescription = "Refresh"
                                                )
                                            }
                                        }
                                    )
                                }

                            },

                            bottomBar = {
                                val navBackStackEntry by navController.currentBackStackEntryAsState()
                                val currentDestination = navBackStackEntry?.destination

                                NavigationBar(
                                    containerColor = Color.White,
                                    modifier = Modifier.drawBehind {
                                        val y = 0f

                                        drawLine(
                                            color = Color(0xFFC5D9E0),
                                            Offset(0f, y),
                                            Offset(size.width, y),
                                            3f
                                        )
                                    }
                                ) {
                                    items.forEachIndexed { index, item ->
                                        val selected =
                                            currentDestination?.hierarchy?.any { it.route == item.route } == true

                                        NavigationBarItem(
                                            icon = {
                                                Icon(
                                                    item.icon,
                                                    contentDescription = item.route,
                                                    tint = if (selected) AnnoRed else AnnoBlue,
                                                    modifier = Modifier.size(24.dp)
                                                )
                                            },
                                            label = {
                                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                                    Text(
                                                        text = stringResource(item.resourceId).uppercase(),
                                                        style = TextStyle(
                                                            fontSize = 12.sp,
                                                            lineHeight = 12.sp,
                                                            fontFamily = FontFamily(Font(R.font.noto_serif)),
                                                            fontWeight = FontWeight(500),
                                                            color = if (selected) AnnoRed else AnnoBlue,
                                                        )
                                                    )
                                                    Divider(
                                                        color = if (selected) AnnoRed else Color.White,
                                                        modifier = Modifier
                                                            .height(1.dp)
                                                            .width(35.dp)
                                                    )
                                                }

                                            },
                                            selected = false,
                                            onClick = {
                                                navController.navigate(item.route) {
                                                    popUpTo(navController.graph.findStartDestination().id) {
                                                        saveState = true
                                                    }
                                                    launchSingleTop = true
                                                    restoreState = true
                                                }
                                            }
                                        )
                                    }
                                }
                            }
                        ) { innerPadding ->
                            NavHost(
                                navController,
                                startDestination = Screen.MAP.route,
                                Modifier.padding(innerPadding)
                            ) {

                                composable(Screen.MAP.route) {
                                    MapScreen(navController, viewModel, detailsViewModel)
                                }
                                composable(Screen.LENS.route) {
                                    Text("LENS")
                                }
                                composable(Screen.LIST.route) {
                                    ListScreen(navController, viewModel, detailsViewModel)
                                }
                                composable(
                                    Screen.DETAILS.route,
                                    enterTransition = {
                                        slideIntoContainer(
                                            towards = AnimatedContentTransitionScope.SlideDirection.Companion.Up,
                                            animationSpec = tween(300)
                                        )
                                    }
                                ) {
                                    DetailsScreen(
                                        navController = navController,
                                        detailsViewModel
                                    )
                                }
                                composable(
                                    Screen.ACCOUNT.route,
                                    enterTransition = {
                                        slideIntoContainer(
                                            towards = AnimatedContentTransitionScope.SlideDirection.Companion.Down,
                                            animationSpec = tween(300)
                                        )
                                    },
                                ) {
                                    Text("ACCOUNT")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}