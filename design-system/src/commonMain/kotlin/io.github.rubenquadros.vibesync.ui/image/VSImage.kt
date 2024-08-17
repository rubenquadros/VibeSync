package io.github.rubenquadros.vibesync.ui.image

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import vibesync.design_system.generated.resources.Res
import vibesync.design_system.generated.resources.compose_multiplatform_logo

@Composable
fun VSImage(
    imageReference: ImageReference,
    accessibilityLabel: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    tint: Color? = null
) {
    AsyncImage(
        model = getImageModel(imageReference),
        modifier = modifier,
        contentDescription = accessibilityLabel,
        contentScale = contentScale,
        colorFilter = tint?.let {
            ColorFilter.tint(color = tint)
        },
        error = getFallback(imageReference)?.let {
            painterResource(it)
        }
    )
}

private fun getImageModel(imageReference: ImageReference): Any {
    return when (imageReference) {
        is ImageReference.ResImage -> imageReference.res
        is ImageReference.ServerImage -> imageReference.imageUrl
    }
}

private fun getFallback(imageReference: ImageReference): DrawableResource? {
    return when (imageReference) {
        is ImageReference.ServerImage -> imageReference.fallback
        else -> null
    }
}

@Preview
@Composable
private fun VSImagePreview() {
    VSImage(
        imageReference = ImageReference.ResImage(Res.drawable.compose_multiplatform_logo),
        accessibilityLabel = "Compose multiplatform logo"
    )
}