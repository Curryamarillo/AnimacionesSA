package com.example.animacionessa.ui.screens

import android.graphics.drawable.Icon
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animacionessa.ui.theme.splash
import java.nio.file.WatchEvent


@Composable
fun ColorAnimationScreen() {

    var animatedColor by rememberSaveable { mutableStateOf(false) }
    val fontColor by animateColorAsState(
        targetValue = if (animatedColor) MaterialTheme.splash.titleBack else MaterialTheme.splash.titleFront,
        label = "fontColor"
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        content = {
            Icon(
                modifier = Modifier
                    .clickable{
                        animatedColor = !animatedColor
                    }
                    .padding(20.dp)
                    .size(200.dp)
                ,
                imageVector = Icons.Filled.ThumbUp,
                contentDescription = "thumb up",
                tint = fontColor
            )
            Text(
                modifier = Modifier
                    .clickable{
                        animatedColor = !animatedColor
                    }
                    .padding(20.dp),
                text = "Presione",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.splash.ring1
            )
        }
    )
}