package com.example.animacionessa.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animacionessa.R
import com.example.animacionessa.ui.theme.splash

@Composable
fun VisibilityAnimationScreen() {

    var visible by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        content = {
            AnimatedVisibility(visible = visible) {
                Image(
                    modifier = Modifier
                        .size(550.dp)
                        .clickable {
                            visible = !visible
                        }
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Fit,
                    painter = painterResource(id = R.drawable.hendrix_poster_psicodelico),
                    contentDescription = "Beatles pop art"
                )
            }
            Text(
                modifier = Modifier
                    .clickable {
                        visible = !visible
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