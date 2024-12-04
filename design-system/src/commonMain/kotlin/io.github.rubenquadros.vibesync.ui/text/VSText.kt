package io.github.rubenquadros.vibesync.ui.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import io.github.rubenquadros.vibesync.ui.VSTheme

@Composable
fun VSText(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = VSTheme.colors.onSurface,
    textStyle: TextStyle = VSTheme.typography.bodySmall,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        modifier = modifier,
        text = text,
        color = textColor,
        style = textStyle,
        textAlign = textAlign 
    )
}