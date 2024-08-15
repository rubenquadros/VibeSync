package io.github.rubenquadros.vibesync.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.rubenquadros.vibesync.ui.theme.DarkColorScheme
import io.github.rubenquadros.vibesync.ui.theme.LightColorScheme
import io.github.rubenquadros.vibesync.ui.theme.VibeSyncBorders
import io.github.rubenquadros.vibesync.ui.theme.VibeSyncColors
import io.github.rubenquadros.vibesync.ui.theme.VibeSyncDarkColorScheme
import io.github.rubenquadros.vibesync.ui.theme.VibeSyncElevations
import io.github.rubenquadros.vibesync.ui.theme.VibeSyncLightColorScheme
import io.github.rubenquadros.vibesync.ui.theme.VibeSyncShapes
import io.github.rubenquadros.vibesync.ui.theme.VibeSyncSpacings
import io.github.rubenquadros.vibesync.ui.theme.VibeSyncTypography
import io.github.rubenquadros.vibesync.ui.theme.typography

private val LocalSpacings = staticCompositionLocalOf {
    VibeSyncSpacings(
        spaceHalf = Dp.Unspecified,
        space1 = Dp.Unspecified,
        space2 = Dp.Unspecified,
        space3 = Dp.Unspecified,
        space4 = Dp.Unspecified,
        space6 = Dp.Unspecified,
        space8 = Dp.Unspecified,
        space12 = Dp.Unspecified,
        space16 = Dp.Unspecified,
        space24 = Dp.Unspecified
    )
}

private val LocalElevations = staticCompositionLocalOf {
    VibeSyncElevations(
        none = Dp.Unspecified,
        level1 = Dp.Unspecified,
        level2 = Dp.Unspecified,
        level3 = Dp.Unspecified,
        level4 = Dp.Unspecified,
        level5 = Dp.Unspecified
    )
}

private val LocalBorders = staticCompositionLocalOf {
    VibeSyncBorders(
        none = Dp.Unspecified,
        width1 = Dp.Unspecified,
        width2 = Dp.Unspecified,
        width3 = Dp.Unspecified,
        width4 = Dp.Unspecified,
        width5 = Dp.Unspecified
    )
}

private val LocalShapes = staticCompositionLocalOf {
    VibeSyncShapes(
        none = RoundedCornerShape(ZeroCornerSize),
        extraSmall = RoundedCornerShape(ZeroCornerSize),
        small = RoundedCornerShape(ZeroCornerSize),
        medium = RoundedCornerShape(ZeroCornerSize),
        large = RoundedCornerShape(ZeroCornerSize),
        extraLarge = RoundedCornerShape(ZeroCornerSize),
        full = RoundedCornerShape(ZeroCornerSize)
    )
}

private val LocalColors = staticCompositionLocalOf {
    VibeSyncColors(
        primary = Color.Unspecified,
        onPrimary = Color.Unspecified,
        primaryContainer = Color.Unspecified,
        onPrimaryContainer = Color.Unspecified,
        secondary = Color.Unspecified,
        onSecondary = Color.Unspecified,
        secondaryContainer = Color.Unspecified,
        onSecondaryContainer = Color.Unspecified,
        tertiary = Color.Unspecified,
        onTertiary = Color.Unspecified,
        tertiaryContainer = Color.Unspecified,
        onTertiaryContainer = Color.Unspecified,
        disabled = Color.Unspecified,
        disabledVariant = Color.Unspecified,
        onDisabled = Color.Unspecified,
        error = Color.Unspecified,
        onError = Color.Unspecified,
        errorContainer = Color.Unspecified,
        onErrorContainer = Color.Unspecified,
        surface = Color.Unspecified,
        surfaceContainer = Color.Unspecified,
        onSurface = Color.Unspecified,
        outline = Color.Unspecified
    )
}

private val LocalTypography = staticCompositionLocalOf {
    VibeSyncTypography(
        displayLarge = TextStyle.Default,
        displayMedium = TextStyle.Default,
        displaySmall = TextStyle.Default,
        headlineLarge = TextStyle.Default,
        headlineMedium = TextStyle.Default,
        headlineSmall = TextStyle.Default,
        titleLarge = TextStyle.Default,
        titleMedium = TextStyle.Default,
        titleSmall = TextStyle.Default,
        labelLarge = TextStyle.Default,
        labelMedium = TextStyle.Default,
        labelSmall = TextStyle.Default,
        bodyLarge = TextStyle.Default,
        bodyMedium = TextStyle.Default,
        bodySmall = TextStyle.Default
    )
}

@Composable
fun VSTheme(
    content: @Composable () -> Unit
) {
    val spacings = VibeSyncSpacings(
        spaceHalf = 2.dp,
        space1 = 4.dp,
        space2 = 8.dp,
        space3 = 12.dp,
        space4 = 16.dp,
        space6 = 24.dp,
        space8 = 32.dp,
        space12 = 48.dp,
        space16 = 64.dp,
        space24 = 96.dp
    )

    val elevations = VibeSyncElevations(
        none = 0.dp,
        level1 = 1.dp,
        level2 = 3.dp,
        level3 = 6.dp,
        level4 = 8.dp,
        level5 = 12.dp
    )

    val borders = VibeSyncBorders(
        none = 0.dp,
        width1 = 1.dp,
        width2 = 2.dp,
        width3 = 4.dp,
        width4 = 8.dp,
        width5 = 16.dp
    )

    val shapes = VibeSyncShapes(
        none = RoundedCornerShape(0.dp),
        extraSmall = RoundedCornerShape(4.dp),
        small = RoundedCornerShape(8.dp),
        medium = RoundedCornerShape(12.dp),
        large = RoundedCornerShape(16.dp),
        extraLarge = RoundedCornerShape(28.dp),
        full = CircleShape
    )

    val vibeSyncColors = if (isSystemInDarkTheme()) {
        VibeSyncDarkColorScheme
    } else {
        VibeSyncLightColorScheme
    }

    val colorScheme = if (isSystemInDarkTheme()) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    val vibeSyncType = typography()

    val typography = VibeSyncTypography(
        displayLarge = vibeSyncType.displayLarge,
        displayMedium = vibeSyncType.displayMedium,
        displaySmall = vibeSyncType.displaySmall,
        headlineLarge = vibeSyncType.headlineLarge,
        headlineMedium = vibeSyncType.headlineMedium,
        headlineSmall = vibeSyncType.headlineSmall,
        titleLarge = vibeSyncType.titleLarge,
        titleMedium = vibeSyncType.titleMedium,
        titleSmall = vibeSyncType.titleSmall,
        labelLarge = vibeSyncType.labelLarge,
        labelMedium = vibeSyncType.labelMedium,
        labelSmall = vibeSyncType.labelSmall,
        bodyLarge = vibeSyncType.bodyLarge,
        bodyMedium = vibeSyncType.bodyMedium,
        bodySmall = vibeSyncType.bodySmall
    )

    CompositionLocalProvider(
        LocalSpacings provides spacings,
        LocalElevations provides elevations,
        LocalBorders provides borders,
        LocalShapes provides shapes,
        LocalColors provides vibeSyncColors,
        LocalTypography provides typography,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography()
        ) {
            content()
        }
    }
}

object VSTheme {
    val spacings: VibeSyncSpacings
        @Composable
        get() = LocalSpacings.current

    val elevations: VibeSyncElevations
        @Composable
        get() = LocalElevations.current

    val borders: VibeSyncBorders
        @Composable
        get() = LocalBorders.current

    val shapes: VibeSyncShapes
        @Composable
        get() = LocalShapes.current

    val colors: VibeSyncColors
        @Composable
        get() = LocalColors.current

    val typography: VibeSyncTypography
        @Composable
        get() = LocalTypography.current
}