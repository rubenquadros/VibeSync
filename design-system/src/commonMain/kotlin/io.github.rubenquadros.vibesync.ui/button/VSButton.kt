package io.github.rubenquadros.vibesync.ui.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.github.rubenquadros.vibesync.ui.VSTheme
import io.github.rubenquadros.vibesync.ui.image.ImageReference
import io.github.rubenquadros.vibesync.ui.image.VSImage
import io.github.rubenquadros.vibesync.ui.text.VSText
import org.jetbrains.compose.ui.tooling.preview.Preview
import vibesync.design_system.generated.resources.Res
import vibesync.design_system.generated.resources.compose_multiplatform_logo

interface VSButton {
    sealed interface Variant {
        data object Primary : Variant
        data object Secondary : Variant
        data object Tertiary : Variant
        data class TertiaryTinted(val color: Color) : Variant
        data object Elevated : Variant
    }

    sealed interface Content {
        data class Text(val text: String) : Content
        data class Icon(val imageReference: ImageReference, val accessibilityLabel: String) : Content
    }

    sealed interface PaddingAdjustment {
        data object Default : PaddingAdjustment
        data object AdjustLeft : PaddingAdjustment
        data object AdjustRight : PaddingAdjustment
    }
}

private val HorizontalPadding = 24.dp
private val VerticalPadding = 8.dp

@Composable
fun VSButton(
    content: VSButton.Content,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    variant: VSButton.Variant = VSButton.Variant.Primary,
    paddingAdjustment: VSButton.PaddingAdjustment = VSButton.PaddingAdjustment.Default
) {
    when (content) {
        is VSButton.Content.Text -> {
            TextButtonInternal(
                modifier = modifier,
                isEnabled = isEnabled,
                textContent = content,
                paddingAdjustment = paddingAdjustment,
                variant = variant,
                onClick = onClick
            )
        }

        is VSButton.Content.Icon -> {
            IconButtonInternal(
                modifier = modifier,
                isEnabled = isEnabled,
                iconContent = content,
                variant = variant,
                onClick = onClick
            )
        }
    }
}

@Composable
private fun TextButtonInternal(
    modifier: Modifier,
    isEnabled: Boolean,
    textContent: VSButton.Content.Text,
    paddingAdjustment: VSButton.PaddingAdjustment,
    variant: VSButton.Variant,
    onClick: () -> Unit,
) {
    val colors = getButtonColors(variant)

    Button(
        modifier = modifier,
        enabled = isEnabled,
        colors = colors,
        contentPadding = getButtonPadding(paddingAdjustment),
        elevation = getButtonElevation(variant),
        border = getButtonBorder(variant = variant, isEnabled = isEnabled),
        shape = VSTheme.shapes.small,
        onClick = onClick
    ) {
        VSText(
            text = textContent.text,
            textColor = if (isEnabled) {
                colors.contentColor
            } else {
                colors.disabledContentColor
            },
            textAlign = when (paddingAdjustment) {
                is VSButton.PaddingAdjustment.AdjustLeft -> TextAlign.Left
                is VSButton.PaddingAdjustment.AdjustRight -> TextAlign.Right
                is VSButton.PaddingAdjustment.Default -> TextAlign.Center
            }
        )
    }
}

@Composable
private fun IconButtonInternal(
    modifier: Modifier,
    isEnabled: Boolean,
    iconContent: VSButton.Content.Icon,
    variant: VSButton.Variant,
    onClick: () -> Unit
) {
    val colors = getIconButtonColors(variant)
    val tint = getIconButtonTint(variant = variant, isEnabled = isEnabled)
    
    when (variant) {
        VSButton.Variant.Secondary -> {
            OutlinedIconButton(
                modifier = modifier,
                enabled = isEnabled,
                colors = colors,
                border = getButtonBorder(variant = variant, isEnabled = isEnabled),
                onClick = onClick
            ) {
                VSImage(
                    imageReference = iconContent.imageReference,
                    accessibilityLabel = iconContent.accessibilityLabel,
                    tint = tint
                )
            }
        }
        else -> {
            IconButton(
                modifier = modifier.then(
                    if (variant is VSButton.Variant.Elevated) {
                        Modifier.shadow(elevation = VSTheme.elevations.level2, shape = CircleShape)
                    } else {
                        Modifier
                    }
                ),
                enabled = isEnabled,
                colors = colors,
                onClick = onClick
            ) {
                VSImage(
                    imageReference = iconContent.imageReference,
                    accessibilityLabel = iconContent.accessibilityLabel,
                    tint = tint
                )
            }
        }
    }
}

@Composable
private fun getButtonColors(variant: VSButton.Variant): ButtonColors {
    return when (variant) {
        VSButton.Variant.Primary -> {
            ButtonColors(
                containerColor = VSTheme.colors.primary,
                contentColor = VSTheme.colors.onPrimary,
                disabledContainerColor = VSTheme.colors.disabled,
                disabledContentColor = VSTheme.colors.onDisabled
            )
        }

        VSButton.Variant.Secondary -> {
            ButtonColors(
                containerColor = Color.Transparent,
                contentColor = VSTheme.colors.primary,
                disabledContainerColor = VSTheme.colors.disabledVariant,
                disabledContentColor = VSTheme.colors.onDisabled
            )
        }

        VSButton.Variant.Tertiary -> {
            ButtonColors(
                containerColor = Color.Transparent,
                contentColor = VSTheme.colors.primary,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = VSTheme.colors.onDisabled
            )
        }
        
        is VSButton.Variant.TertiaryTinted -> {
            ButtonColors(
                containerColor = Color.Transparent,
                contentColor = variant.color,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = VSTheme.colors.onDisabled
            )
        }

        VSButton.Variant.Elevated -> {
            ButtonColors(
                containerColor = Color.Transparent,
                contentColor = VSTheme.colors.primary,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = VSTheme.colors.onDisabled
            )
        }
    }
}

@Composable
private fun getButtonElevation(variant: VSButton.Variant): ButtonElevation {
    return when (variant) {
        VSButton.Variant.Elevated -> {
            ButtonDefaults.buttonElevation(
                defaultElevation = VSTheme.elevations.level2,
                pressedElevation = VSTheme.elevations.level2,
                focusedElevation = VSTheme.elevations.level2,
                hoveredElevation = VSTheme.elevations.level2,
                disabledElevation = VSTheme.elevations.level2
            )
        }

        else -> {
            ButtonDefaults.buttonElevation()
        }
    }
}

private fun getButtonPadding(paddingAdjustment: VSButton.PaddingAdjustment): PaddingValues {
    return when (paddingAdjustment) {
        is VSButton.PaddingAdjustment.Default -> {
            ButtonDefaults.ContentPadding
        }

        is VSButton.PaddingAdjustment.AdjustLeft -> {
            PaddingValues(
                top = VerticalPadding, bottom = VerticalPadding,
                start = 0.dp, end = HorizontalPadding * 2
            )
        }

        is VSButton.PaddingAdjustment.AdjustRight -> {
            PaddingValues(
                top = VerticalPadding, bottom = VerticalPadding,
                start = HorizontalPadding * 2, end = 0.dp
            )
        }
    }
}

@Composable
private fun getButtonBorder(variant: VSButton.Variant, isEnabled: Boolean): BorderStroke? {
    return when (variant) {
        VSButton.Variant.Secondary -> {
            BorderStroke(
                color = if (isEnabled) {
                    VSTheme.colors.primary
                } else {
                    VSTheme.colors.disabled
                },
                width = VSTheme.borders.width1
            )
        }

        else -> null
    }
}

@Composable
private fun getIconButtonColors(variant: VSButton.Variant): IconButtonColors {
    val buttonColors = getButtonColors(variant)
    
    return IconButtonColors(
        containerColor = buttonColors.containerColor,
        contentColor = buttonColors.contentColor,
        disabledContainerColor = buttonColors.disabledContainerColor,
        disabledContentColor = buttonColors.disabledContentColor
    )
}

@Composable
private fun getIconButtonTint(variant: VSButton.Variant, isEnabled: Boolean): Color? {
    return when {
        !isEnabled -> VSTheme.colors.onDisabled
        variant is VSButton.Variant.TertiaryTinted -> variant.color
        else -> null
    }
}

@Preview
@Composable
private fun VSTextButtonEnabledPreview() {
    VSTheme {
        Column(
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

@Preview
@Composable
private fun VSTextButtonDisabledPreview() {
    VSTheme {
        Column(
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

@Preview
@Composable
private fun VSIconButtonEnabledPreview() {
    VSTheme {
        Column(
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

@Preview
@Composable
private fun VSIconButtonDisabledPreview() {
    VSTheme {
        Column(
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