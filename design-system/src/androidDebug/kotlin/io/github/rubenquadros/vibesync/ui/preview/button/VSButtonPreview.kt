package io.github.rubenquadros.vibesync.ui.preview.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import io.github.rubenquadros.vibesync.ui.VSTheme
import io.github.rubenquadros.vibesync.ui.button.VSButton
import io.github.rubenquadros.vibesync.ui.image.ImageReference
import vibesync.design_system.generated.resources.Res
import vibesync.design_system.generated.resources.compose_multiplatform_logo

@PreviewLightDark
@Composable
private fun VSTextButtonEnabledPreview() {
    VSTheme {
        Column(
            modifier = Modifier.padding(VSTheme.spacings.space4),
            verticalArrangement = Arrangement.spacedBy(VSTheme.spacings.space4)
        ) {
            variantList.forEach { variant ->
                VSButton(
                    variant = variant,
                    content = VSButton.Content.Text(
                        text = "Click me!"
                    ),
                    onClick = { }
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun VSTextButtonDisabledPreview() {
    VSTheme {
        Column(
            modifier = Modifier.padding(VSTheme.spacings.space4),
            verticalArrangement = Arrangement.spacedBy(VSTheme.spacings.space4)
        ) {
            variantList.forEach { variant ->
                VSButton(
                    variant = variant,
                    content = VSButton.Content.Text(
                        text = "Click me!"
                    ),
                    isEnabled = false,
                    onClick = { }
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun VSIconButtonEnabledPreview() {
    VSTheme {
        Column(
            modifier = Modifier.padding(VSTheme.spacings.space4),
            verticalArrangement = Arrangement.spacedBy(VSTheme.spacings.space4)
        ) {
            variantList.forEach { variant ->
                VSButton(
                    variant = variant,
                    content = VSButton.Content.Icon(
                        imageReference = ImageReference.ResImage(Res.drawable.compose_multiplatform_logo),
                        accessibilityLabel = "Compose multiplatform logo"
                    ),
                    isEnabled = true,
                    onClick = { }
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun VSIconButtonDisabledPreview() {
    VSTheme {
        Column(
            modifier = Modifier.padding(VSTheme.spacings.space4),
            verticalArrangement = Arrangement.spacedBy(VSTheme.spacings.space4)
        ) {
            variantList.forEach { variant ->
                VSButton(
                    variant = variant,
                    content = VSButton.Content.Icon(
                        imageReference = ImageReference.ResImage(Res.drawable.compose_multiplatform_logo),
                        accessibilityLabel = "Compose multiplatform logo"
                    ),
                    isEnabled = false,
                    onClick = { }
                )
            }
        }
    }
}

private val variantList: List<VSButton.Variant> @Composable get() = listOf(
    VSButton.Variant.Primary,
    VSButton.Variant.Secondary,
    VSButton.Variant.Tertiary,
    VSButton.Variant.TertiaryTinted(color = VSTheme.colors.onSurface),
    VSButton.Variant.Elevated
)