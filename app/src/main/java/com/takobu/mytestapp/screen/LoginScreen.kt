package com.takobu.mytestapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.takobu.mytestapp.R

@Composable
fun LoginScreen(onLogin: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE5E4FF)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.baked_goods_2), contentDescription = null)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Welcome", fontSize = 24.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onLogin, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))) {
                Text(text = "Login", color = Color.White)
            }
        }
    }
}