package nl.anno.amsterdam.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nl.anno.amsterdam.MainViewModel
import nl.anno.amsterdam.R
import nl.anno.amsterdam.ui.theme.AnnoBlue
import nl.anno.amsterdam.ui.theme.AnnoRed

@Composable
fun CenturyFilter(viewModel: MainViewModel) {
    val startCentury = 15
    val endCentury = 21

    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
    ) {
        Spacer(Modifier.width(0.dp))
        (startCentury..endCentury).forEach { century ->

            AnnoButtonOutlined(
                onclick = {
                    viewModel.setFilterCentury(if (viewModel.filterCentury.value == century) -1 else century)
                },
                color = if (viewModel.filterCentury.value == century) Color.LightGray else Color.White,
                content = {
                    Row {
                        // Replace AnnoMarker with a corresponding Composable if available
                        // AnnoMarker(year = century * 100)
                        AnnoMarker(year = century * 100, showWithoutBottom = true)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "${century}c.")

                    }
                })
            Spacer(Modifier.width(8.dp))
        }
    }
}
@Composable
fun AnnoSearchBar(viewModel: MainViewModel) {
    var text = viewModel.search.collectAsState().value

    OutlinedTextField(
        value = text,
        onValueChange = { viewModel.setSearch(it) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(Color.White, RoundedCornerShape(5.dp)),
        placeholder = {
            Text(
                text = stringResource(R.string.search_by_address),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Font(R.font.noto_serif)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF073854)
                )
            )
        },
        textStyle = LocalTextStyle.current.copy(color = AnnoBlue),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = { viewModel.setSearch(text) }),
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = stringResource(R.string.search),
                tint = AnnoBlue
            )
        },
        trailingIcon = {
            if (text.isNotEmpty()) {
                IconButton(onClick = { text = ""; viewModel.setSearch("") }) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = stringResource(R.string.clear),
                        tint = AnnoRed
                    )
                }
            }
        }
    )
}