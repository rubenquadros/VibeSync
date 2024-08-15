package io.github.rubenquadros.vibesync.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import vibesync.design_system.generated.resources.Res
import vibesync.design_system.generated.resources.lato_bold
import vibesync.design_system.generated.resources.lato_light
import vibesync.design_system.generated.resources.lato_regular

@Composable
fun latoFontFamily() = FontFamily(
    Font(Res.font.lato_light, FontWeight.Light),
    Font(Res.font.lato_regular, FontWeight.Normal),
    Font(Res.font.lato_bold, FontWeight.Bold)
)