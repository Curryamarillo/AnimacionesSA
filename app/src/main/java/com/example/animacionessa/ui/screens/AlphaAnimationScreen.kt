package com.example.animacionessa.ui.screens

import android.media.Image
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animacionessa.R
import com.example.animacionessa.ui.theme.splash

@Composable
fun AlphaAnimationScreen() {
    var animatedAlpha by rememberSaveable { mutableStateOf(true) }
    val alpha by animateFloatAsState(
        targetValue = if (animatedAlpha) 1f else 0.3f,
        label ="animación alpha"
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        content = {
            Image(
                modifier = Modifier
                    .graphicsLayer(scaleX = alpha, scaleY = alpha)
                    .clickable{
                        animatedAlpha = !animatedAlpha
                    }
                    .padding(20.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Fit,
                painter = painterResource(id = R.drawable.beatles_abbey_road),
                contentDescription = "Beatles pop art"
            )
            Text(
                modifier = Modifier
                    .clickable{
                        animatedAlpha = !animatedAlpha
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