package nextstep.signup.ui.theme.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview
@Composable
private fun TitlePreView() {
    TitleView("Welcome to Compose \uD83D\uDE80")
}

@Composable
fun TitleView(
    title: String
) {
    Text(
        text = title,
        fontSize = 26.sp,
        color = Color(0xFF000000),
        fontWeight = FontWeight.Bold
    )
}