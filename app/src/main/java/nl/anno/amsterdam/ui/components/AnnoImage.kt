package nl.anno.amsterdam.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import nl.anno.amsterdam.R

@Composable
fun AnnoImage(
    modifier: Modifier,
    imageLink: String,
    contentDescription: String,
) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageLink)
            .crossfade(true)
            .build(),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier,
    ) {
        val state = painter.state
        if (state is AsyncImagePainter.State.Loading) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(Modifier.size(16.dp))
            }
        } else if (state is AsyncImagePainter.State.Error) {
            Image(
                painter = painterResource(id = R.drawable.placeholder_building),
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
            )
        } else {
            SubcomposeAsyncImageContent()
        }
    }
}