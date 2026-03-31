package com.example.tugas2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                TugasWeek3()
            }
        }
    }
}

@Composable
fun TugasWeek3() {
    // input
    var nameInput by remember { mutableStateOf("") }

    // output
    var displayText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Input text
        OutlinedTextField(
            value = nameInput,
            onValueChange = { nameInput = it },
            label = { Text("Masukkan Nama Anda") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // tombol untuk Proses
        Button(
            onClick = {
                if (nameInput.isNotEmpty()) {
                    displayText = "Haii, $nameInput!"
                } else {
                    displayText = "Tolong Masukkan Nama!"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Tekan Aku><")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // text output
        if (displayText.isNotEmpty()) {
            Text(
                text = displayText,
                fontSize = 22.sp,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTugas() {
    TugasWeek3()
}
