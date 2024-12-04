package io.github.rubenquadros.vibesync.ui.preview.image

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import io.github.rubenquadros.vibesync.ui.VSTheme
import io.github.rubenquadros.vibesync.ui.image.ImageReference
import io.github.rubenquadros.vibesync.ui.image.VSImage
import vibesync.design_system.generated.resources.Res
import vibesync.design_system.generated.resources.compose_multiplatform_logo

@PreviewLightDark
@Composable
private fun VSImagePreview() {
    VSTheme(isPreview = true) {
        VSImage(
            imageReference = ImageReference.ResImage(Res.drawable.compose_multiplatform_logo),
            accessibilityLabel = "Compose multiplatform logo"
        )
    }
}