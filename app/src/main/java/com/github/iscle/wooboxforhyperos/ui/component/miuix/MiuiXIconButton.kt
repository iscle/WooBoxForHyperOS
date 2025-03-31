package com.github.iscle.wooboxforhyperos.ui.component.miuix

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
fun MiuiXIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable () -> Unit
) {
    val realInteractionSource = remember(interactionSource) {
        interactionSource ?: MutableInteractionSource()
    }
    val isPressed = realInteractionSource.collectIsPressedAsState().value
    Box(
        modifier =
            modifier
                .size(40.dp)
                .clickable(
                    onClick = onClick,
                    enabled = enabled,
                    role = Role.Button,
                    interactionSource = realInteractionSource,
                    indication = null
                ),
        contentAlignment = Alignment.Center
    ) {
        val contentColor = when {
            isPressed -> LocalContentColor.current.copy(alpha = 0.9f)
            enabled -> LocalContentColor.current.copy(alpha = 0.8f)
            else -> LocalContentColor.current.copy(alpha = 0.5f)
        }
        CompositionLocalProvider(LocalContentColor provides contentColor, content = content)
    }
}