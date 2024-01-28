package nl.anno.amsterdam.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nl.anno.amsterdam.R
import nl.anno.amsterdam.ui.components.AnnoNext
import nl.anno.amsterdam.ui.components.SkipButton
import nl.anno.amsterdam.ui.theme.AnnoandroidTheme

@Composable
fun Onboarding(setOnBoardingDone: () -> Unit) {
    var onboardingPage by remember { mutableStateOf(1) }

    when (onboardingPage) {
        1 -> OnboardingPage(
            imageResId = R.drawable.skizze2,
            text = "    Discover Amsterdam's\n architectural heritage with\n",
            logoResId = R.drawable.ob1,
            backgroundColor = Color(0xFF00425A),
            textColor = Color(0xFFC5D9E0),
            skipButtonText = "SKIP",
            nextButtonText = "Next >",
            nextPage = {
                // You can add logic here if needed
                onboardingPage = 2
            },
            setOnBoardingDone = {
                setOnBoardingDone()
            }
        )
        2 -> OnboardingPage(
            imageResId = R.drawable.skizze2,
            text = "Augmented Reality \nThe Window to Amsterdam's Past",
            logoResId = R.drawable.ob2,
            backgroundColor = Color(0xFF00425A),
            textColor = Color(0xFFC5D9E0),
            skipButtonText = "SKIP",
            nextButtonText = "Next >",
            nextPage = {
                // You can add logic here if needed
                onboardingPage = 3
            },
            setOnBoardingDone = {
                setOnBoardingDone()
            }
        )
        3 -> OnboardingPage(
            imageResId = R.drawable.skizze2,
            text = stringResource(R.string.get_lost_in_history_navigate_amsterdam_s_iconic_buildings_on_the_map),
            logoResId = R.drawable.ob3,
            backgroundColor = Color(0xFF00425A),
            textColor = Color(0xFFC5D9E0),
            skipButtonText = stringResource(R.string.skip_2),
            nextButtonText = stringResource(R.string.next_2),
            nextPage = {
                // You can add logic here if needed
                onboardingPage = 4
            },
            setOnBoardingDone = {
                setOnBoardingDone()
            }
        )
        4 -> OnboardingPage(
            imageResId = R.drawable.skizze2,
            text = stringResource(R.string.unlock_the_building_s_secrets_explore_detailed_information), // Add your custom text here
            logoResId = R.drawable.ob4, // Replace with your actual logo resource ID
            backgroundColor = Color(0xFF00425A),
            textColor = Color(0xFFC5D9E0),
            skipButtonText = stringResource(R.string.skip_3),
            nextButtonText = stringResource(R.string.get_started),
            nextPage = {
                       setOnBoardingDone()
            },
            setOnBoardingDone = {
                // You can add logic here if needed
                setOnBoardingDone()
            }
        )
        else -> {
            // Handle other cases or provide a default behavior
        }
    }
}

@Composable
fun OnboardingPage(
    imageResId: Int,
    text: String,
    logoResId: Int,
    backgroundColor: Color,
    textColor: Color,
    skipButtonText: String,
    nextButtonText: String,
    nextPage: () -> Unit,
    setOnBoardingDone: () -> Unit,
) {
    AnnoandroidTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = backgroundColor,
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Bild
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .scale(1.2f), // Adjust the size here if needed
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.height(15.dp))

                // Text
                Text(
                    text = text,
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(Font(R.font.oswald)),
                        fontWeight = FontWeight(500),
                        color = textColor,
                        textAlign = TextAlign.Center // Center the text
                    ),
                    modifier = Modifier.scale(1f)
                )

                Image(
                    painter = painterResource(id = logoResId),
                    contentDescription = null,
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp)
                )

                Box(
                    modifier = Modifier
                        .height(350.dp)
                        .fillMaxWidth()
                        .padding(5.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        SkipButton(
                            onclick = {
                               setOnBoardingDone()
                            },
                            text = skipButtonText
                        )
                    }
                    AnnoNext(
                        onClick = {
                            nextPage()
                        },
                        text = nextButtonText,
                    )
                }
            }
        }
    }
}
