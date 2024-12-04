package io.github.rubenquadros.vibesync.ui.preview.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import io.github.rubenquadros.vibesync.ui.VSTheme
import io.github.rubenquadros.vibesync.ui.text.VSTitle

@PreviewLightDark
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