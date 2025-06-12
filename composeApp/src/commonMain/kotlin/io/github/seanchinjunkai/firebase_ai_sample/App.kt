package io.github.seanchinjunkai.firebase_ai_sample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.touchlab.kermit.Logger
import io.github.seanchinjunkai.firebase.ai.Firebase
import io.github.seanchinjunkai.firebase.ai.GenerativeBackend
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@Composable
@Preview
fun App() {
    val coroutineScope = rememberCoroutineScope()
    var prompt by remember { mutableStateOf("Summarize the benefits of Kotlin Multiplatform") }
    var content by remember { mutableStateOf("") }
    var showProgress by remember { mutableStateOf(false) }

    MaterialTheme {
        Column(Modifier.verticalScroll(rememberScrollState())
            .fillMaxWidth().padding(16.dp)
        ) {
            Row {
                TextField(value = prompt,
                    onValueChange = { prompt = it },
                    modifier = Modifier.weight(7f)
                )
                TextButton(onClick = {
                    if (prompt.isNotBlank()) {
                        coroutineScope.launch {
                            content = generateContent(prompt)
                            showProgress = true
                            showProgress = false
                        }
                    }
                },
                    modifier = Modifier.weight(3f)
                        .padding(all = 4.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Text("Submit")
                }
            }

            Spacer(Modifier.height(16.dp))
            if (showProgress) {
                CircularProgressIndicator()
            } else {
                Text(content)
            }
        }
    }
}

suspend fun generateContent(prompt: String) : String {
    Logger.i(
        messageString = "Starting generation of content for prompt: $prompt",
        tag = "firebase-ai"
    )
    val model = Firebase.ai(GenerativeBackend.GOOGLE_AI).generativeModel("gemini-2.0-flash")
    val response = model.generateContent(prompt)
    return response.text ?: "No content generated"
}