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
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import io.github.rubenquadros.vibesync.ui.VSTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun VSTitle(
    title: String,
    modifier: Modifier = Modifier,
    textColor: Color = VSTheme.colors.onSurface,
    textStyle: TextStyle = VSTheme.typography.titleLarge,
    fontWeight: FontWeight = FontWeight.Bold
) {
    Text(
        modifier = modifier.semantics { heading() },
        text = title,
        color = textColor,
        style = textStyle,
        fontWeight = fontWeight
    )
}

@Preview
@Composable
private fun VSTitlePreview() {
    VSTheme {
        Box(modifier = Modifier.fillMaxWidth().background(VSTheme.colors.surface)) {
            VSTitle(
                modifier = Modifier.padding(VSTheme.spacings.space2).align(Alignment.Center),
                title = "Title 1"
            )
        }
    }
}