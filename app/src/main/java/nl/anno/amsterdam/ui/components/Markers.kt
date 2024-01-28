package nl.anno.amsterdam.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp
import nl.anno.amsterdam.ui.theme.AnnoBlue
import nl.anno.amsterdam.ui.theme.AnnoRed

@Composable
fun AnnoMarker(year: Int? = null, outerFillColor: Color? = null, showWithoutBottom: Boolean = false) {
    val fillColor = when {
        year != null -> getColorForYear(year)
        outerFillColor != null -> outerFillColor
        else -> Color.Gray
    }

    Canvas(modifier = Modifier.size(width = 20.dp, height = if (showWithoutBottom) 20.dp else 30.dp)) {
        val path = Path().apply {
            if (showWithoutBottom) {
                // Draw a square
                addRect(Rect(0f, 0f, size.width, size.height))
            } else {
                // Draw the original custom shape with the bottom triangle
                moveTo(0f, 0f)
                lineTo(size.width, 0f)
                lineTo(size.width, size.height - 10.dp.toPx())
                lineTo(size.width / 2, size.height)
                lineTo(0f, size.height - 10.dp.toPx())
                close()
            }
        }

        drawPath(path, fillColor)

        // Inner rectangle
        val rect = Rect(Offset(6.dp.toPx(), 6.dp.toPx()), Offset(14.dp.toPx(), 14.dp.toPx()))
        drawRect(Color.White, topLeft = rect.topLeft, size = rect.size)
    }
}

fun getColorForYear(year: Int): Color {
    // Color mappings
    val colorMappings: List<Pair<IntRange, Color>> = listOf(
        1000..1599 to AnnoRed,
        1600..1699 to AnnoBlue,
        1700..1799 to Color.Green,
        1800..1899 to Color.Magenta,
        1900..1999 to Color.Yellow,
        2000..2099 to Color.Red
    )

    // Find the matching color
    for ((range, color) in colorMappings) {
        if (year in range) {
            return color
        }
    }

    return Color.Gray // Default
}