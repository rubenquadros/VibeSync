package io.github.rubenquadros.vibesync.ui.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import io.github.rubenquadros.vibesync.ui.VSTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

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

@Preview
@Composable
private fun VSTextPreview() {
    VSTheme {
        Box(modifier = Modifier.fillMaxWidth().background(VSTheme.colors.surface)) {
            VSText(
                modifier = Modifier.padding(VSTheme.spacings.space2).align(Alignment.Center),
                text = "Hello there"
            )
        }
    }
}