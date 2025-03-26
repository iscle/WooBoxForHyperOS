package com.github.iscle.wooboxforhyperos.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.iscle.wooboxforhyperos.R
import com.github.iscle.wooboxforhyperos.ui.theme.WooBoxForHyperOSTheme

private const val COLOR_WHITE_TEXT_LIGHT = 0xFF000000
private const val COLOR_WHITE_TEXT_DARK = 0xFFFFFFFF
private const val COLOR_AUTHOR_TIPS_LIGHT = 0xFF656565
private const val COLOR_AUTHOR_TIPS_DARK = 0xFFACACAC
private const val COLOR_SPINNER_LIGHT = 0xFF999999
private const val COLOR_SPINNER_DARK = 0xFF666666

@Composable
fun MiuiTextSummary(
    title: String?,
    subtitle: String?,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(vertical = 15.dp)
    ) {
        // title
        Text(
            text = title ?: "",
            color = if (isSystemInDarkTheme()) Color(COLOR_WHITE_TEXT_DARK) else Color(COLOR_WHITE_TEXT_LIGHT),
            fontSize = if (title.isNullOrEmpty()) 15.sp else 18.25.sp,
            fontWeight = FontWeight(500),
        )

        if (subtitle != null) {
            Text(
                text = subtitle,
                color = if (isSystemInDarkTheme()) Color(COLOR_AUTHOR_TIPS_DARK) else Color(COLOR_AUTHOR_TIPS_LIGHT),
                fontSize = 13.75.sp,
                fontWeight = FontWeight(350),
            )
        }
    }
}

@Composable
fun MiuiTextSummaryWithArrow(
    title: String?,
    subtitle: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(vertical = 17.75.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MiuiTextSummary(
            title = title,
            subtitle = subtitle,
            modifier = Modifier.weight(1f)
        )

        Image(
            painter = painterResource(R.drawable.ic_arrow_right),
            contentDescription = "Right arrow",
            colorFilter = ColorFilter.tint(
                color = if (isSystemInDarkTheme()) Color(COLOR_WHITE_TEXT_DARK) else Color(COLOR_WHITE_TEXT_LIGHT),
            )
        )
    }
}

@Composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
private fun MiuiTextSummaryWithArrowPreview() {
    WooBoxForHyperOSTheme {
        Surface {
            MiuiTextSummaryWithArrow(
                title = "Test title",
                subtitle = "Test subtitle",
                onClick = {}
            )
        }
    }
}