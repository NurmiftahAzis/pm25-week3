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
    // State untuk menyimpan teks yang diketik (input)
    var nameInput by remember { mutableStateOf("") }

    // State untuk menyimpan pesan yang akan ditampilkan (output)
    var displayText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1. Input Field (TextField)
        OutlinedTextField(
            value = nameInput,
            onValueChange = { nameInput = it },
            label = { Text("Masukkan Nama Anda") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 2. Button untuk Proses
        Button(
            onClick = {
                // Logika: Ambil input dan masukkan ke dalam pesan "Hello"
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

        // 3. Text Display (Output)
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