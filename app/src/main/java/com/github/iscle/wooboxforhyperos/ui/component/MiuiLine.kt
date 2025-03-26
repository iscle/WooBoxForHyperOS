package com.github.iscle.wooboxforhyperos.ui.component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private const val LIGHT_COLOR = 0xFFE6E6E6
private const val DARK_COLOR = 0xFF2D2D2D

@Composable
fun MiuiLine(
    modifier: Modifier = Modifier,
) {
    HorizontalDivider(
        modifier = modifier.padding(vertical = 23.5.dp),
        thickness = 0.9.dp,
        color = if (isSystemInDarkTheme()) Color(DARK_COLOR) else Color(LIGHT_COLOR)
    )
}

@Preview
@Composable
private fun MiuiLinePreview() {
    MiuiLine()
}