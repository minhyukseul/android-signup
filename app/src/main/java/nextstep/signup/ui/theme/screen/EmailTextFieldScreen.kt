package nextstep.signup.ui.theme.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

const val EMAIL_REX_ERROR = "이메일 형식이 올바르지 않습니다."

const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"

@Preview(showBackground = true)
@Composable
private fun EmailTextFieldPreview() {
    EmailTextFieldScreen("Username","")
}

@Composable
fun EmailTextFieldScreen(
    label: String = "",
    inputText: String,
    onValueChange: (String) -> Unit = {},
    onValidChanged: (Boolean) -> Unit = {},
) {
    val isFocused = remember { mutableStateOf(false) }
    var supportingText = getErrorMessage(inputText)
    TextField(
        value = inputText,
        onValueChange = {
            onValueChange(it)
            supportingText = getErrorMessage(it)
            onValidChanged(supportingText.isNotEmpty())
        },
        label = {
            Text(
                text = label,
                fontSize = if (isFocused.value) 12.sp else 16.sp,
            )
        },
        colors = TextFieldDefaults.colors(
            focusedLabelColor = Color(0xFF2196F3),
            unfocusedLabelColor = Color(0xFF49454F),
            errorIndicatorColor = Color(0xFFB3261E),
            errorLabelColor = Color(0xFFB3261E),
        ),
        isError = supportingText.isNotEmpty(),
        keyboardOptions = KeyboardOptions(keyboardType= KeyboardType.Email),
        visualTransformation = VisualTransformation.None,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .fillMaxWidth()
            .onFocusChanged { focusState ->
                isFocused.value = focusState.isFocused
            },
        supportingText = {
            Text(
                text = supportingText, color = Color(0xFFB3261E), fontSize = 12.sp
            )
        })
}

private fun getErrorMessage(
    input: String
): String {
    return if (!input.matches(Regex(EMAIL_REGEX))) {
        EMAIL_REX_ERROR
    } else {
        ""
    }
}